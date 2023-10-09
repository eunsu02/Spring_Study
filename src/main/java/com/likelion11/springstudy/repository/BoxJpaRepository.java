package com.likelion11.springstudy.repository;

import com.likelion11.springstudy.domain.entity.BoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoxJpaRepository extends JpaRepository<BoxEntity,Long> {

    default BoxEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("해당 박스가 존재하지 않습니다."));
    }

    default BoxEntity findByCodeOrThrow(String code) {
        return findByCode(code).orElseThrow(() -> new IllegalArgumentException("해당 박스가 존재하지 않습니다."));
    }

    Optional<BoxEntity> findByCode(String code);//해당 객체가 있으면 boxentity 반환, 없으면  optional 반환
}