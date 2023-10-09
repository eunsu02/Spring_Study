package com.likelion11.springstudy.dto.response.letter;

import com.likelion11.springstudy.domain.entity.LetterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LetterGetResponse {

    private String title;
    private String content;
    private String writer;

    public static LetterGetResponse of(LetterEntity letter){
        return new LetterGetResponse(letter.getTitle(), letter.getContent(),letter.getWriter());
    }
}
