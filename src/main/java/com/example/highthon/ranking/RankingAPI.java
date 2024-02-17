package com.example.highthon.ranking;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ranking")
@RequiredArgsConstructor
public class RankingAPI {

    private final RankingRepository rankingRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ranking> getRankings() {
        return rankingRepository.findTop10ByOrderBySecondsDesc();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRanking(@RequestBody @Valid CreateRankingRequest request) {
        Ranking ranking = rankingRepository.findByToken(request.getToken())
                .orElseGet(request::toEntity);
        if (request.getSeconds() > ranking.getSeconds()) {
            ranking.setSeconds(request.getSeconds());
        }
        rankingRepository.save(ranking);
    }
}
