package com.study.hy.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class Comment {
    private int commentNo;
    private String comment;
    private String author;
    private String password;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private int boardNo;
}
