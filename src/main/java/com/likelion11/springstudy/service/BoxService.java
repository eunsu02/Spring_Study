package com.likelion11.springstudy.service;

import com.likelion11.springstudy.domain.entity.BoxEntity;
import com.likelion11.springstudy.domain.entity.MemberEntity;
import com.likelion11.springstudy.dto.request.box.BoxCreateRequest;
import com.likelion11.springstudy.dto.response.box.BoxGetResponse;
import com.likelion11.springstudy.repository.BoxJpaRepository;
import com.likelion11.springstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {

    private final BoxJpaRepository boxJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    public BoxGetResponse getByCode(String boxCode) {
        return BoxGetResponse.of(boxJpaRepository.findByCodeOrThrow(boxCode));
    }

    @Transactional
    public String create(BoxCreateRequest request, Long memberId) {
        BoxEntity box = boxJpaRepository.save(
                BoxEntity.builder()
                        .name(request.name())
                        .code(generateCode())
                        .member(findMemberById(memberId))
                        .build()
        );
        return box.getCode();
    }

    private String generateCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    } //랜덤한 8자리 코드 생성하여 반환.

    private MemberEntity findMemberById(Long memberId) {
        return memberJpaRepository.findByIdOrThrow(memberId);
    }
}