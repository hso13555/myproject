package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Ai_table")
public class AiRecomend extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(length=30, nullable = false)
    // private String Ai_standard;  ///봄,여름,가을,겨울,아침,점심,저녁.....
    
    @Column(length=30, nullable = false)
    private String Ai_time; ///시간에 관련된 모든 레시피

    @Column(length=30, nullable = false)
    private String Ai_weather; // 날씨와 관련된 모든 레시피

    @Column(length=30, nullable = false)
    private String Ai_season;  // 계절이랑 관련된 모든 레시피

    @ManyToOne //N:1
    //회원과 핸드폰의 관계에서 핸드폰을 보면 됩니다. 핸드폰은 자신을 소유한 회원이 있습니다. 하지만 이 회원은 핸드폰을 여러개 소지할 수도 있고 
    //하나만 소지할 수도 있겠죠. 회원쪽에서 핸드폰을 바라본다면 @OneToMany 관계지만 핸드폰이 회원을 바라본다면 @ManyToOne이 되는겁니다
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


}
