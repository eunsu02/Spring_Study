package com.likelion11.springstudy.domain.entity;

import com.likelion11.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "box") //ㅇㅣ름을 지정해주지 않으면 테이블이름에 스네이크 케이스를 적용한 이름이 테이블 이름으로 들어감.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class BoxEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    private static final int DEFAULT_LETTER_LIMIT = 20;
    private int letterLimit = DEFAULT_LETTER_LIMIT;
    private String code;

    //member id와 1:1 연결
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private MemberEntity member;

    //letter_id와 1:m 연결
//    @OneToMany(mappedBy = "box")
//    private List<LetterEntity> letters = new ArrayList<>();
    @Builder
    public BoxEntity(String name, int letterLimit, String code, MemberEntity member) {
        validate(letterLimit);
        this.name = name;
        this.code = code;
        this.member = member;
    }

    private void validate(int letterLimit) {
        validateLetterLimit(letterLimit);
    }


    private void validateLetterLimit(int letterLimit) {
        if (letterLimit > DEFAULT_LETTER_LIMIT || letterLimit < 0) {
            throw new IllegalArgumentException("Invalid Letter Limit");
        }
    }

}

