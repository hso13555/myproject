package com.example.demo.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.util.Code;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    private final TokenProvider tokenProvider;


    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;

}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("JwTFilter 작동중");
        
        String jwt = resolveToken(request);
try {
    if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
        Authentication authentication = tokenProvider.getAuthentication(jwt);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
} catch (SignatureException e) {
    log.info("잘못된 JWT 서명입니다.");
    request.setAttribute("exception", Code.WRONG_TYPE_SIGNATURE.getCode());
} catch (MalformedJwtException e) {
    log.info("유효하지 않은 구성의 JWT 토큰입니다.");
    request.setAttribute("exception", Code.WRONG_TYPE_TOKEN.getCode());
} catch (ExpiredJwtException e) {
    log.info("만료된 JWT 토큰입니다.");
    request.setAttribute("exception", Code.EXPIRED_TOKEN.getCode());
} catch (UnsupportedJwtException e) {
    log.info("지원되지 않는 형식이나 구성의 JWT 토큰입니다.");
    request.setAttribute("exception", Code.UNSUPPORTED_TOKEN.getCode());
} catch (IllegalArgumentException e) {
    log.info(e.toString().split(":")[1].trim());
    request.setAttribute("exception", Code.UNSUPPORTED_TOKEN.getCode());
}
 
        log.info("jwt토큰에 걸리는게 없어요");
        filterChain.doFilter(request, response);
    }
}
