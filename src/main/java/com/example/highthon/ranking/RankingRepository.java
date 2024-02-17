package com.example.highthon.ranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, String> {

    List<Ranking> findTop10ByOrderBySecondsDesc();
    Optional<Ranking> findByToken(String token);
}
