package com.likelion11.springstudy.dto.request.box;

public record BoxCreateRequest (String name){
}
// records는 일반 class와는 다르게 생성자, getter, hashCode(), equals() ,toString()를 제공해줌
//DTO, domain model class, 일시적/불변적 데이터 저장에 사용
