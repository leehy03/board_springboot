package com.study.hy.board.model.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardRequestDto {
    private int boardNo;
    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private int views;
}

