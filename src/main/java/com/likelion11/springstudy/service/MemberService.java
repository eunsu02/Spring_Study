package com.likelion11.springstudy.service;

import com.likelion11.springstudy.domain.entity.MemberEntity;
import com.likelion11.springstudy.dto.response.member.MemberGetResponse;
import com.likelion11.springstudy.dto.request.member.MemberSignInRequest;
import com.likelion11.springstudy.repository.BoxJpaRepository;
import com.likelion11.springstudy.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;
    private final BoxJpaRepository BoxJpaRepository;
    public MemberGetResponse getById(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }
    protected MemberEntity findById(Long id){
        return memberJpaRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("해당하는 회원을 찾을 수 없습니다."));
    }
}
