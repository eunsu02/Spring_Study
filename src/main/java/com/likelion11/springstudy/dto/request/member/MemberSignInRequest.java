package com.likelion11.springstudy.dto.request.member;

public record MemberSignInRequest(
        String username,
        String password,
        String nickname
) {
}
