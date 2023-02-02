package com.example.demo.jwt;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.dto.TokenDto;
import com.example.demo.entity.RefreshToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TokenProvider {

  private static final String AUTHORITIES_KEY = "auth";
  private static final String BEARER_TYPE = "bearer";
  private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;
  private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 30 * 30;

  private final Key key;

  // 주의점: 여기서 @Value는 `springframework.beans.factory.annotation.Value`소속이다! lombok의 @Value와 착각하지 말것!
  //     * @param secretKey
  public TokenProvider(@Value("${jwt.secret}") String secretKey) {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    this.key = Keys.hmacShaKeyFor(keyBytes);
  }

  // 토큰 생성
  public TokenDto generateTokenDto(Authentication authentication) {
log.info("Hear please" + authentication);

    String authorities = authentication
      .getAuthorities()
      .stream()
      .map(GrantedAuthority::getAuthority)
      .collect(Collectors.joining(","));

    long now = (new Date()).getTime();

    Date tokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
    Date refreshTokenExpiresln = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);

    System.out.println(tokenExpiresIn);

    String accessToken = Jwts
      .builder()
      .setSubject(authentication.getName())
      .claim(AUTHORITIES_KEY, authorities)
      .setExpiration(tokenExpiresIn)
      .signWith(key, SignatureAlgorithm.HS512)
      .compact();

    String refreshToken = Jwts
      .builder()
      .setSubject(authentication.getName())
      .claim(AUTHORITIES_KEY, authorities)
      .setExpiration(refreshTokenExpiresln)
      .signWith(key, SignatureAlgorithm.HS512)
      .compact();

    return TokenDto
      .builder()
      .grantType(BEARER_TYPE)
      .accessToken(accessToken)
      .accessTokenExp(tokenExpiresIn)
      .refreshToken(refreshToken)
      .key(authentication.getName())
      .build();
  }

  public Authentication getAuthentication(String accessToken) {
    Claims claims = parseClaims(accessToken);

    if (claims.get(AUTHORITIES_KEY) == null) {
      throw new RuntimeException("권한 정보가 없는 토큰입니다.");
    }

    Collection<? extends GrantedAuthority> authorities = Arrays
      .stream(claims.get(AUTHORITIES_KEY).toString().split(","))
      .map(SimpleGrantedAuthority::new)
      .collect(Collectors.toList());

    UserDetails principal = new User(claims.getSubject(), "", authorities);

    return new UsernamePasswordAuthenticationToken(principal, "", authorities);
  }

  public boolean validateToken(String token) {
    Jws<Claims> claimsJws = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token);
    return !claimsJws.getBody().isEmpty();

  }


  private Claims parseClaims(String accessToken) {
    try {
      return Jwts
        .parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(accessToken)
        .getBody();
    } catch (ExpiredJwtException e) {
      return e.getClaims();
    }
  }

  public String validateRefreshToken(RefreshToken refreshTokenObj) {
    // refresh 객체에서 refreshToken 추출
    String refreshToken = refreshTokenObj.getRefreshToken();

    try {
      // 검증
      Jws<Claims> claims = Jwts
        .parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(refreshToken);

      //refresh 토큰의 만료시간이 지나지 않았을 경우, 새로운 access 토큰을 생성합니다.
      if (!claims.getBody().getExpiration().before(new Date())) {
        return recreationAccessToken(
          claims.getBody().get("sub").toString(),
          claims.getBody().get("auth")
        );
      }
    } catch (Exception e) {
      //refresh 토큰이 만료되었을 경우, 로그인이 필요합니다.
      return null;
    }

    return null;
  }

  public String recreationAccessToken(String userEmail, Object auth) {
    Claims claims = Jwts.claims().setSubject(userEmail);
    claims.put("auth", auth);
    Date now = new Date();

    //access Token
    String accessToken = Jwts
      .builder()
      .setClaims(claims)
      .setIssuedAt(now)
      .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_EXPIRE_TIME))
      .signWith(key, SignatureAlgorithm.HS512)
      .compact();

    return accessToken;
  }
}
