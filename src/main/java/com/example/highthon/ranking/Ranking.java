package com.example.highthon.ranking;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ranking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="token", columnDefinition = "MEDIUMTEXT")
    private String token;

    @Column(name="name", length = 50)
    private String name;

    @Column(nullable = false)
    @Setter
    private int seconds;
}
