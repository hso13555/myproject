package com.example.demo.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(value = { AuditingEntityListener.class }) //Auditing 을 적용하기 위해서 추가함
@MappedSuperclass //공통 매핑 정보가 필요할때 사용하는 어노테이션 부모 클래스를  상속 받는 자식 클래스에 매핑 정보만 제공
@Getter
@Setter
public abstract class BaseTimeEntity {

  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime regTime;

  @LastModifiedDate
  private LocalDateTime updateTime;
}
