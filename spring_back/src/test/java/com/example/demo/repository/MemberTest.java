// package com.example.demo.repository;

// import com.example.demo.entity.Member;

// import lombok.extern.log4j.Log4j2;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityNotFoundException;
// import javax.persistence.PersistenceContext;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.security.test.context.support.WithMockUser;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.transaction.annotation.Transactional;

// @SpringBootTest
// @Transactional
// @Log4j2
// public class MemberTest {

//   @Autowired
//   MemberRepository memberRepository;

//   @PersistenceContext
//   EntityManager em;

//   @Test
//   public void auditorTest() {
//     Member newmember = Member
//       .builder()
//       .email("test")
//       .password("test")
//       .nickname("test")
//       .build();
//     memberRepository.save(newmember);

//     em.flush();
//     em.clear();

//     Member member = memberRepository
//       .findById(newmember.getId())
//       .orElseThrow(EntityNotFoundException::new);

//     log.info("register time : " + member.getRegTime());
//     log.info("update time : " + member.getUpdateTime());
//     log.info("create member : " + member.getCreatedBy());
//     log.info("modify member : " + member.getModifiedBy());
//   }
// }
