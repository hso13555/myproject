package com.example.demo.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FreezerListRespDto {
    List<FreezerRespDto> freezers;

    @Builder
    public FreezerListRespDto(List<FreezerRespDto> freezerList) {
        this.freezers = freezerList;
    }


    
}
