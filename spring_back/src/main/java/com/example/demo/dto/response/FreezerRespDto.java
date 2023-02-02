package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FreezerRespDto {

    private Long id;
    private String name;

    @Builder
    public FreezerRespDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
}
