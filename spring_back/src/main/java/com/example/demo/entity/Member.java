package com.example.demo.entity;

import com.example.demo.dto.response.MemberRespDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(nullable = false)
  private String userEmail;

  @Column(nullable = false)
  private String userPw;

  @Column(nullable = false)
  private String userName;

  @Enumerated(EnumType.STRING)
  private Authority authority;

  @JsonIgnore
  @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
  private List<LikedRecipe> likedRecipe;

  @Builder
  public Member(
    Long id,
    String userEmail,
    String userPw,
    String userName,
    Authority authority
  ) {
    this.id = id;
    this.userEmail = userEmail;
    this.userPw = userPw;
    this.userName = userName;
    this.authority = authority;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUserPw(String userPw) {
    this.userPw = userPw;
  }

  public MemberRespDto toDto() {
    return MemberRespDto
      .builder()
      .id(id)
      .userEmail(userEmail)
      .userName(userName)
      .userPw(userPw)
      .build();
  }
}
