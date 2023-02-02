// package com.example.demo.repository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.demo.entity.Freezer;
// import com.example.demo.entity.Item;
// import com.example.demo.entity.Member;
// import com.example.demo.service.InventoryService;

// @SpringBootTest
// @Transactional
// public class InventoryTest {

//   @Autowired
//   ItemRepository itemRepository;

//   @Autowired
//   MemberRepository memberRepository;

//   @Autowired
//   InventoryService inventoryService;

//   @Autowired
//   InventoryItemRepository InventoryItemRepository;
  
//   @Autowired
//   InventoryRepository inventoryRepository;

//   @Autowired
//   FreezerRepository freezerRepository;

//   public Item saveItem(){
//     Item item = Item.builder().name("장바구니담기 테스트").carb(0).chol(0).fat(0).img("df").kcal(0).per(0).potassium(0).protein(0).sodium(0).build();
//     return itemRepository.save(item);
//   }


//   public Freezer createFreezer(){
//     Freezer freezer = Freezer.builder().name("프리저").build();
//     return freezerRepository.save(freezer);
//   }

//   public Member saveMember(){
//     Member member = Member.builder().email("test@test.com").nickname("dfdf").password("test").build();
//     return memberRepository.save(member);
//   }

  


  // }

    



