package com.likelion11.springstudy.repository;

import com.likelion11.springstudy.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}
