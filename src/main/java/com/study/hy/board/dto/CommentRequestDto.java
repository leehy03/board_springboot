package com.study.hy.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private int boardNo;

    private String author;

    private String comment;

    private String password;

}
