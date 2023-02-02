package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.FreezerReqDto;
import com.example.demo.dto.response.FreezerListRespDto;
import com.example.demo.dto.response.FreezerRespDto;
import com.example.demo.entity.Freezer;
import com.example.demo.entity.Member;
import com.example.demo.repository.FreezerRepository;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class FreezerService {

  private final MemberRepository memberRepository;
  private final FreezerRepository freezerRepository;

  //냉장고 등록
  public FreezerRespDto addFreezer(
    FreezerReqDto freezerReqDto,
    String userEmail
  ) {
    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    freezerReqDto.setMember(member);
    Freezer freezer = freezerRepository.save(freezerReqDto.toEntity());
    return freezer.toDto();
  }

  //로그인 된 아이디의 냉장고 리스트 조회
  public FreezerListRespDto getFreezerList(String userEmail) {
    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    List<FreezerRespDto> freezerRespDto = freezerRepository
      .findByMemberId(member.getId())
      .stream()
      .map(Freezer::toDto)
      .collect(Collectors.toList());

    FreezerListRespDto freezerListRespDto = FreezerListRespDto
      .builder()
      .freezerList(freezerRespDto)
      .build();
    return freezerListRespDto;
  }

  //로그인 된 아이디의 냉장고 개별조회(index 0~2)
  public FreezerRespDto getFreezer(String userEmail, int index) {
    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    List<FreezerRespDto> freezerRespDtoList = freezerRepository
      .findByMemberId(member.getId())
      .stream()
      .map(Freezer::toDto)
      .collect(Collectors.toList());
    return freezerRespDtoList.get(index);
  }

  //로그인 된 아이디의 냉장고 개별수정(index 0~2)
  public FreezerRespDto update(
    String userEmail,
    int index,
    FreezerReqDto requestDto
  ) {
    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    List<Freezer> freezerList = freezerRepository
      .findByMemberId(member.getId());

    Freezer freezer = freezerList.get(index);
    freezer.update(requestDto.getName());
    return freezer.toDto();
  }

  //로그인 된 아이디의 냉장고 개별삭제(index 0~2)
  public void delete(String userEmail, int index) {
    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    List<Freezer> freezerList = freezerRepository
      .findByMemberId(member.getId());

    Freezer freezer = freezerList.get(index);
    freezerRepository.delete(freezer);
  }
}
