package com.study.hy.board.model.entity;

import java.time.LocalDateTime;

public class Board {
    private int boardNo;
    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private int views;

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(LocalDateTime createdDt) {
        this.createdDt = createdDt;
    }

    public LocalDateTime getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(LocalDateTime updatedDt) {
        this.updatedDt = updatedDt;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardNo=" + boardNo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", password='" + password + '\'' +
                ", createdDt=" + createdDt +
                ", updatedDt=" + updatedDt +
                ", views=" + views +
                '}';
    }
}
