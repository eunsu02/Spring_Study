package com.likelion11.springstudy.repository;

import com.likelion11.springstudy.domain.entity.LetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, Long> {
    default LetterEntity findByIdOrThrow(Long id){
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 편지가 존재하지 않습니다."));
    }
}