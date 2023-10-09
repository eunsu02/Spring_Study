package com.likelion11.springstudy.controller;


import com.likelion11.springstudy.dto.request.member.MemberSignInRequest;
import com.likelion11.springstudy.dto.response.member.MemberGetResponse;
import com.likelion11.springstudy.service.BoxService;
import com.likelion11.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 특정 사용자 정보를 조회하는 API
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberService.getById(memberId));
    }
}
