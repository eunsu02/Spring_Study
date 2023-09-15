package com.likelion11.springstudy.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller //웹서비스를 개발할때 렌더링 해주는 역할
@RestController //rest api개발을 위해서 return 값을 json 형식으로 바꿔줌
@RequestMapping("/api") // 보통 앞에 /
public class HealthCheckController {


    //@GetMapping(value = "/health",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<String> healthCheck(){
        //return ResponseEntity.ok("ok");
    //}
    //일반적으로 responseentity 를 이용함. 이 안에 어지간한 notfound 200등등 들어가 있음
    //보통 response class 만들어서 이걸 주는 식으로 코드를 만든다.

    @GetMapping(value = "/health", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> healthCheck() { //접근제어자 -> 제어자 순서로 , return type, 메소드 이름(파라미터), map은 dict와 유사
        Map<String, String> map = new HashMap<>();
        map.put("status", "OK");
        map.put("message", "Health Check is OK");
        return ResponseEntity.ok(map); //response entity 활용하자
    }
}
