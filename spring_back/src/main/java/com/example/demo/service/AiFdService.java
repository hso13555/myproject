package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.convert.ReadingConverter;

import com.example.demo.dto.AiFdDto;
import com.example.demo.dto.TimeFdDto;
import com.example.demo.entity.AiRecomend;
import com.example.demo.entity.TimeMenu;
import com.example.demo.repository.AiFdRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class AiFdService {

    private final AiFdRepository aiFdRepository;
    

    //시간에 따른 추천 레시피 들고오기
    //사실상 timeMenuList에는 아침 점심 저녁 칼럼이 있는데 현재 시간에 따라 아침 점심 저녁 레시피를 보여준다. 
    //현재시간을 어떻게 아침,점심,메뉴 레시피에 매치 해 시켜줄 수 있을까?
    // @scheduled?
    public List<AiFdDto> airecomend(List<AiFdDto> aiFdDto) {
         List<AiRecomend> aiMenuList = aiFdRepository.findAll();
         List<AiFdDto> timeDtoList = new ArrayList<>();
         
         //현재 시간
         int currentTime = LocalDateTime.now().getHour();
         //아침
         if
           for(AiRecomend aiRecomend: aiMenuList ){
               timeDtoList.add(TimeFdDto.toTimeFdDto());
           }
           return timeDtoList;
          }
         

               
         

         
         
        }

}
