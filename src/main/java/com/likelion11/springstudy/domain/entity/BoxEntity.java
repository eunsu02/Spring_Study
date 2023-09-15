package com.likelion11.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "box")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class BoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    //member id와 1:1 연결
    @OneToOne()
    @JoinColumn(name="member_id")
    private MemberEntity member;
    //letter_id와 1:m 연결
    @OneToMany(mappedBy = "box")
    private List<LetterEntity> letters = new ArrayList<>();
}
