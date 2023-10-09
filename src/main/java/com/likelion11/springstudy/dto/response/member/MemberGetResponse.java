package com.likelion11.springstudy.dto.response.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelion11.springstudy.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberGetResponse {

    private String name;
    private String nickname;

    public static MemberGetResponse of(MemberEntity member) {
        return new MemberGetResponse(member.getUsername(), member.getNickname());
    }
}

//    @JsonProperty("name")//이름 마음에 안들 경우에 이렇게 key이름을 바꿔줄 수 있다.
//    private String name;
//    private String nickname; //이게 json에서 key 가 된다.
