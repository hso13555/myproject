package com.example.demo.service;

import com.example.demo.dto.MailDto;
import com.example.demo.dto.request.PwFinderRequestDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SendMailService {

  private final MemberRepository memberRepository;
  private final JavaMailSender mailSender;
  private final PasswordEncoder passwordEncoder;

  private static final String FROM_ADDRESS = "ppkk24@naver.com";

  public MailDto createMailAndChangePassword(PwFinderRequestDto requestDto) {
    String str = getTempPassword();
    MailDto dto = new MailDto();

    dto.setAddress(requestDto.getUserEmail());
    dto.setTitle(
      requestDto.getUserName() +
      "님의 미미 냉장고 프로젝트의 임시비밀번호 안내 이메일 입니다."
    );
    dto.setMessage(
      "안녕하세요. 미미 냉장고 프로젝트의 임시비밀번호 안내 관련 이메일 입니다." +
      "[" +
      requestDto.getUserName() +
      "]" +
      "님의 임시 비밀번호는 " +
      str +
      " 입니다."
    );
    updatePassword(str, requestDto.getUserEmail());
    return dto;
  }

  public void updatePassword(String str, String userEmail) {
    log.info("userEmail" + userEmail);
    Optional<Member> member = memberRepository.findByUserEmail(userEmail);
    Member thisMember = member.get();
    thisMember.setUserPw(passwordEncoder.encode((str)));
    memberRepository.save(thisMember);
  }

  public String getTempPassword() {
    char[] charSet = new char[] {
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      'A',
      'B',
      'C',
      'D',
      'E',
      'F',
      'G',
      'H',
      'I',
      'J',
      'K',
      'L',
      'M',
      'N',
      'O',
      'P',
      'Q',
      'R',
      'S',
      'T',
      'U',
      'V',
      'W',
      'X',
      'Y',
      'Z',
    };

    String str = "";

    int idx = 0;
    for (int i = 0; i < 10; i++) {
      idx = (int) (charSet.length * Math.random());
      str += charSet[idx];
    }
    return str;
  }

  public void mailSend(MailDto mailDto) {
    System.out.println("이멜 전송 완료!");
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(mailDto.getAddress());
    message.setFrom(SendMailService.FROM_ADDRESS);
    message.setSubject(mailDto.getTitle());
    message.setText(mailDto.getMessage());

    mailSender.send(message);
  }
}
