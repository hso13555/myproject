package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.FreezerReqDto;
import com.example.demo.dto.response.CMRespDto;
import com.example.demo.dto.response.FreezerListRespDto;
import com.example.demo.dto.response.FreezerRespDto;
import com.example.demo.service.FreezerService;
import com.example.demo.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/freezer")
@Log4j2
public class FreezerController {

  private final MemberService memberService;
  private final FreezerService freezerService;

  //냉장고 추가
  @PostMapping("/add")
  public ResponseEntity<?> saveFreezer(
    @RequestBody @Valid FreezerReqDto freezerRequestDto,
    BindingResult bindingResult
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorMap = new HashMap<>();
      for (FieldError fe : bindingResult.getFieldErrors()) {
        errorMap.put(fe.getField(), fe.getDefaultMessage());
      }
      throw new RuntimeException(errorMap.toString());
    }
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    FreezerRespDto freezerRespDto = freezerService.addFreezer(
      freezerRequestDto,
      email
    );

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고 등록 성공")
        .body(freezerRespDto)
        .build(),
      HttpStatus.CREATED
    );
  }

  //냉장고 전체 목록
  @GetMapping
  public ResponseEntity<?> getFreezerList() {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    FreezerListRespDto freezerListRespDto = freezerService.getFreezerList(
      email
    );
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고 목록 가져오기 성공")
        .body(freezerListRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  //냉장고 읽기
  @GetMapping("/{index}")
  public ResponseEntity<?> getOneFreezer(@PathVariable("index") int index) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    FreezerRespDto freezerRespDto = freezerService.getFreezer(email, index);
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고 한건 조회 성공")
        .body(freezerRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  //냉장고수정
  @PutMapping("/{index}")
  public ResponseEntity<?> updateFreezer(
    @PathVariable("index") int index,
    @RequestBody @Valid FreezerReqDto requestDto,
    BindingResult bindingResult
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorMap = new HashMap<>();
      for (FieldError fe : bindingResult.getFieldErrors()) {
        errorMap.put(fe.getField(), fe.getDefaultMessage());
      }

      throw new RuntimeException(errorMap.toString());
    }
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    FreezerRespDto FreezerRespDto = freezerService.update(
      email,
      index,
      requestDto
    );
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고 수정 성공")
        .body(FreezerRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  //냉장고 삭제
  @DeleteMapping("/{index}")
  public ResponseEntity<?> deleteFreezer(@PathVariable("index") int index) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    freezerService.delete(email, index);
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고 삭제하기 성공")
        .body(null)
        .build(),
      HttpStatus.OK
    );
  }
}
