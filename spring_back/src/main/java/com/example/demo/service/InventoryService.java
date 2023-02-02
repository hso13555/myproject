package com.example.demo.service;

import com.example.demo.dto.request.InventoryItemReqDto;
import com.example.demo.dto.response.InventoryItemListRespDto;
import com.example.demo.dto.response.InventoryItemRespDto;
import com.example.demo.entity.Freezer;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.InventoryItem;
import com.example.demo.entity.Item;
import com.example.demo.entity.Member;
import com.example.demo.repository.FreezerRepository;
import com.example.demo.repository.InventoryItemRepository;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class InventoryService {

  private final ItemRepository itemRepository;
  private final FreezerRepository freezerRepository;
  private final InventoryRepository inventoryRepository;
  private final InventoryItemRepository inventoryItemRepository;
  private final MemberRepository memberRepository;

  //인벤토리 추가 및 아이템 담기
  @Transactional(rollbackFor = RuntimeException.class)
  public InventoryItemRespDto addInventory(
    InventoryItemReqDto inventoryItemReqDto,
    String userEmail,
    int index
  ) {
    log.info("인벤토리 추가 실행");
    Item item = itemRepository.findByName(inventoryItemReqDto.getItemName());

    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    List<Freezer> freezer = freezerRepository.findByMemberId(member.getId());
    Inventory inventory = inventoryRepository.findByFreezerId(
      freezer.get(index).getId()
    );

    if (inventory == null) {
      inventory = Inventory.builder().freezer(freezer.get(index)).build();
      inventoryRepository.save(inventory);
    }

    InventoryItem savedInventoryItem = inventoryItemRepository.findByInventoryIdAndItemId(
      inventory.getId(),
      item.getId()
    );

    if (savedInventoryItem != null) {
      savedInventoryItem.addCount(inventoryItemReqDto.getCount());
      InventoryItemRespDto inventoryItemRespDto = InventoryItemRespDto
        .builder()
        .item(item)
        .build();
      return inventoryItemRespDto;
    } else {
      InventoryItem inventoryItem = inventoryItemRepository.save(
        inventoryItemReqDto.toEntity(item, inventory)
      );
      return inventoryItem.toDto();
    }
  }

  //그냥 내 모든 리스트 조회
  public InventoryItemListRespDto getAllItem(String userEmail) {
    List<InventoryItemRespDto> inventoryItem = inventoryItemRepository
      .findByInventory_Freezer_Member_UserEmail(userEmail)
      .stream()
      .map(InventoryItem::toDto)
      .collect(Collectors.toList());

    InventoryItemListRespDto inventoryItemListRespDto = InventoryItemListRespDto
      .builder()
      .inventoryItemList(inventoryItem)
      .build();
    return inventoryItemListRespDto;
  }

  // 해당 냉장고의 전체 리스트 조회
  public InventoryItemListRespDto getInventoryItemList(
    String userEmail,
    int index
  ) {
    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    List<Freezer> freezer = freezerRepository.findByMemberId(member.getId());
    Inventory inventory = inventoryRepository.findByFreezerId(
      freezer.get(index).getId()
    );
    List<InventoryItemRespDto> inventoryItemRespDto = inventoryItemRepository
      .findByInventoryId(inventory.getId())
      .stream()
      .map(InventoryItem::toDto)
      .collect(Collectors.toList());
    InventoryItemListRespDto inventoryItemListRespDto = InventoryItemListRespDto
      .builder()
      .inventoryItemList(inventoryItemRespDto)
      .build();

    return inventoryItemListRespDto;
  }

  // 개별 조회
  // public ItemDto getOneInventoryItem(
  //   String userEmail,
  //   int index,
  //   Long itemId
  // ) {
  //   Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
  //   List<Freezer> freezer = freezerRepository.findByMemberId(member.getId());
  //   Inventory inventory = inventoryRepository.findByFreezerId(
  //     freezer.get(index).getId()
  //   );
  //   Item inventoryItem = inventoryItemRepository
  //     .findByInventoryIdAndItemId(inventory.getId(), itemId)
  //     .getItem();
  //   ItemDto dto = modelMapper.map(inventoryItem, ItemDto.class);
  //   return dto;
  // }

  // 수정
  public InventoryItemRespDto modifyInventoryItem(
    String userEmail,
    int index,
    Long itemId,
    InventoryItemReqDto inventoryItemDto
  ) {
    Member member = memberRepository.findByUserEmail(userEmail).orElseThrow();
    List<Freezer> freezer = freezerRepository.findByMemberId(member.getId());
    Inventory inventory = inventoryRepository.findByFreezerId(
      freezer.get(index).getId()
    );
    InventoryItem inventoryItem = inventoryItemRepository.findByInventoryIdAndItemId(
      inventory.getId(),
      itemId
    );

    inventoryItem.update(inventoryItemDto);
    return inventoryItem.toDto();
  }

  // 삭제
  @Transactional(rollbackFor = RuntimeException.class)
  public void deleteInventoryItem(Long inventoryItemId) {
      inventoryItemRepository.deleteById(inventoryItemId);
    }
    
  }
