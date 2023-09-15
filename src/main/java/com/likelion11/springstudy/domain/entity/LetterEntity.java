package com.likelion11.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "Letter")
public class LetterEntity {
//id (PK) : Long
    @Id @GeneratedValue
    private Long id;
//쓴 사람
    @Column(nullable = false,length = 10)
    private String writer;
//title: String(VARCHAR)
    @Column(nullable = false,length = 50)
    private  String title;
//content: String(TEXT)
    @Column(nullable = false,columnDefinition = "TEXT")
    private  String content;
//photo_url: String VARCHAR
    @Column(nullable = true)
    private  String photo_url;
//created_at: datetime
    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private LocalDateTime created_at = LocalDateTime.now();
//box id와 m:1 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id")
    private BoxEntity box;
}
