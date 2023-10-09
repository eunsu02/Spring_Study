package com.likelion11.springstudy.service;

import com.likelion11.springstudy.domain.entity.LetterEntity;
import com.likelion11.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion11.springstudy.dto.response.letter.LetterGetResponse;
import com.likelion11.springstudy.repository.LetterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {

    private final LetterJpaRepository letterJpaRepository;

    @Transactional
    public String create(LetterCreateRequest request) {
        LetterEntity letter = letterJpaRepository.save(LetterEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
        return letter.getId().toString();
    }

    public LetterGetResponse getById(Long id) {
        return LetterGetResponse.of(letterJpaRepository.findByIdOrThrow(id));
    }
}
