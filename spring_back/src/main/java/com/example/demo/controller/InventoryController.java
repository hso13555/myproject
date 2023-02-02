package com.example.demo.controller;

import com.example.demo.dto.request.InventoryItemReqDto;
import com.example.demo.dto.response.CMRespDto;
import com.example.demo.dto.response.InventoryItemListRespDto;
import com.example.demo.dto.response.InventoryItemRespDto;
import com.example.demo.service.InventoryService;
import com.example.demo.service.MemberService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

  private final InventoryService inventoryService;
  private final MemberService memberService;

  //추가
  @PostMapping("/add/{index}")
  public ResponseEntity<?> addInventoryItem(
    @RequestBody @Valid InventoryItemReqDto inventoryItemReqDto,
    @PathVariable int index,
    BindingResult bindingResult
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorMap = new HashMap<>();
      for (FieldError fe : bindingResult.getFieldErrors()) {
        errorMap.put(fe.getField(), fe.getDefaultMessage());
      }

      System.out.println("==========================");
      System.out.println(errorMap.toString());
      System.out.println("==========================");

      throw new RuntimeException(errorMap.toString());
    }

    String email = memberService.getMyInfoBySecurity().getUserEmail();

    InventoryItemRespDto inventoryItemRespDto = inventoryService.addInventory(
      inventoryItemReqDto,
      email,
      index
    );

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고에 아이템 등록 성공")
        .body(inventoryItemRespDto)
        .build(),
      HttpStatus.CREATED
    );
  }

  //해당 냉장고 전체 조회
  @GetMapping("/{index}")
  public ResponseEntity<?> getAllInventoryItem(@PathVariable int index) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();

    InventoryItemListRespDto inventoryItemListRespDto = inventoryService.getInventoryItemList(
      email,
      index
    );
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고아이템 조회 성공")
        .body(inventoryItemListRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  //내 꺼 전체 조회
  @GetMapping("/all")
  public ResponseEntity<?> getAllItem() {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    InventoryItemListRespDto inventoryItemListRespDto = inventoryService.getAllItem(
      email
    );
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고아이템 조회 성공")
        .body(inventoryItemListRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  //수정
  @PutMapping("/{index}/{itemId}")
  public ResponseEntity<?> modifyInventoryItem(
    @PathVariable("itemId") Long itemId,
    @PathVariable("index") int index,
    @RequestBody InventoryItemReqDto inventoryItemDto
  ) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    InventoryItemRespDto inventoryItemRespDto = inventoryService.modifyInventoryItem(
      email,
      index,
      itemId,
      inventoryItemDto
    );

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고아이템 수정 성공")
        .body(inventoryItemRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  //삭제
  @DeleteMapping("/delete/{inventoryItemId}")
  public ResponseEntity<?> deleteInventoryItem(
    @PathVariable("inventoryItemId") Long inventoryItemId
  ) {
    inventoryService.deleteInventoryItem(inventoryItemId);
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("냉장고아이템 삭제 성공")
        .body(null)
        .build(),
      HttpStatus.OK
    );
  }
}
