package com.example.demo.controller;

import com.example.demo.dto.request.ItemReqDto;
import com.example.demo.dto.response.CMRespDto;
import com.example.demo.dto.response.ItemListRespDto;
import com.example.demo.dto.response.ItemRespDto;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/item")
public class ItemController {

  private final ItemService itemService;

  @PostMapping("/add") //상품추가
  public ResponseEntity<?> addItem(@RequestBody ItemReqDto itemReqDto) {
    ItemRespDto itemRespDto = itemService.addItem(itemReqDto);
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("아이템 등록 완료")
        .body(itemRespDto)
        .build(),
      HttpStatus.CREATED
    );
  }

  @PutMapping("/{itemId}") //상품수정 ... -> 수정요망
  public ResponseEntity<?> modifyItem(
    @PathVariable("itemId") Long itemId,
    @RequestBody ItemReqDto itemReqDto
  ) throws Exception {
    ItemRespDto itemRespDto = itemService.modify(itemReqDto);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("아이템 수정 완료")
        .body(itemRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  @GetMapping // 상품목록 받기
  public ResponseEntity<?> readAllItem() {
    ItemListRespDto itemRespListDto = itemService.getItemList();

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("아이템 전체목록 받기 완료")
        .body(itemRespListDto)
        .build(),
      HttpStatus.OK
    );
  }

  //아이템 하나 조회
  @GetMapping("/{itemName}")
  public ResponseEntity<?> readOneItem(
    @PathVariable("itemName") String itemName
  ) throws Exception {
    ItemRespDto itemRespDto = itemService.getOneItem(itemName);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("아이템 한개 목록 받기 완료")
        .body(itemRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  //아이템 삭제
  @DeleteMapping("/{itemId}")
  public ResponseEntity<?> deleteItem(@PathVariable("itemId") Long itemId) {
    itemService.remove(itemId);
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("아이템 한개 삭제 완료")
        .body(null)
        .build(),
      HttpStatus.OK
    );
  }
}
