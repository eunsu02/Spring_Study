package com.likelion11.springstudy.controller;


import com.likelion11.springstudy.dto.request.box.BoxCreateRequest;
import com.likelion11.springstudy.dto.response.box.BoxGetResponse;
import com.likelion11.springstudy.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class BoxController {

    private final BoxService boxService;
    @PostMapping
    public ResponseEntity<Void> createLetterBox(@RequestBody BoxCreateRequest request, Long memberId) {
        URI location = URI.create("/api/box/" + boxService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }

    //boxcode로 편지함 조회
    @GetMapping("/{boxCode}")
    public ResponseEntity<BoxGetResponse> getBox(@PathVariable String boxCode) {
        return ResponseEntity.ok(boxService.getByCode(boxCode));
    }
}
