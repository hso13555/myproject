package com.example.demo.service;

import com.example.demo.dto.request.ItemReqDto;
import com.example.demo.dto.response.ItemListRespDto;
import com.example.demo.dto.response.ItemRespDto;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ItemService {

  private final ItemRepository itemRepository;

  //상품등록
  public ItemRespDto addItem(ItemReqDto itemReqDto) {
    Item item = itemRepository.save(itemReqDto.toEntity());
    return item.toDto();
  }

  //상품 조회
  public ItemRespDto getOneItem(String itemName) {
    Item item = itemRepository.findByName(itemName);
    return item.toDto();
  }

  //상품 수정
  public ItemRespDto modify(ItemReqDto itemReqDto) {
    Item item = itemRepository.findById(itemReqDto.getId()).get();
    item.change(itemReqDto);
    return item.toDto();
  }

  //삭제 처리
  public void remove(Long id) {
    itemRepository.deleteById(id);
  }

  // 전체 목록
  public ItemListRespDto getItemList() {
    List<ItemRespDto> resultList = itemRepository
      .findAll()
      .stream()
      .map(Item::toDto)
      .collect(Collectors.toList());
    ItemListRespDto itemRespListDto = ItemListRespDto
      .builder()
      .itemList(resultList)
      .build();
    return itemRespListDto;
  }
}
