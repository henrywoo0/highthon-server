package com.example.highthon.ranking;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRankingRequest {

    @NotBlank(message = "유저 식별자는 필수 값입니다.")
    private String token;

    @NotBlank(message = "유저의 이름은 필수 값입니다.")
    private String name;

    @NotBlank(message = "게임 플레이에 걸린 시간(초)은 필수 값입니다.")
    private String seconds;

    public Ranking toEntity() {
        return Ranking.builder()
                .token(token)
                .name(name)
                .seconds(Integer.parseInt(seconds))
                .build();
    }
}
