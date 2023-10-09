package com.likelion11.springstudy.dto.response.box;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelion11.springstudy.domain.entity.BoxEntity;
import com.likelion11.springstudy.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

public record BoxGetResponse(
        String name
) {

    // BoxEntty 를 받아서 BoxGetResponse로 변환하는 메서드
    public static BoxGetResponse of(BoxEntity box) {
        return new BoxGetResponse(box.getName());
    }
}

