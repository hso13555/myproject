package com.example.demo.dto;

import com.example.demo.entity.TimeMenu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  //기본 생성자 생성
@Builder
//@AllArgsConstructor  /// 모든 필드를 매개변수로 하는 생성자 
public class AiFdDto {
    private String id;
    private String ai_time;
    private String ai_weather;
    private String ai_season;


    
  
   




    public AiFdDto(String id, String ai_time, String ai_weather, String ai_season) {
        this.id = id;
        this.ai_time = ai_time;
        this.ai_weather = ai_weather;
        this.ai_season = ai_season;
    }









    public AiFdDto toAiFdDto(){
        return AiFdDto.builder().id(id)
                                .ai_time(ai_time)
                                .ai_weather(ai_weather)
                                .ai_season(ai_season)
                                .build();
                                
    }
  

    // public static TimeFdDto toTimeFdDto(TimeMenu timeMenu){
    //     TimeFdDto timeFdDto = new TimeFdDto();
    //     timeFdDto.setId(timeMenu.getId());
    //     timeFdDto.setTimefd_name(timeMenu.getTimefd_name());
    //     timeFdDto.setTimefd_igr(timeMenu.getTimefd_igr());
    //     timeFdDto.setTimefd_explain(timeMenu.getTimefd_explain());
    //     return timeFdDto;
    //}
        
}
