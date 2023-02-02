package com.example.demo.entity;

import org.hibernate.CustomEntityDirtinessStrategy.AttributeChecker;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;


public class AiRecomendJsonConverter implements AttributeConverter<AiRecomend, String> {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    //AiRecomend 객체 -> Json  문자열로 변환
    @Override
    public String convertToDatabaseColumn(AiRecomend attribute) {
        try{
            return objectMapper.writeValueAsString(attribute);
        }catch(Exception e){
        return null;
        }
    }
    
    //Json 문자열을 AiRecomend 객체로 변환
    @Override
    public AiRecomend convertToEntityAttribute(String jsonString) {
        try{
            return objectMapper.readValue(jsonString, AiRecomend.class);
        }catch(Exception e){
            return null;
        }
    }
    
}
