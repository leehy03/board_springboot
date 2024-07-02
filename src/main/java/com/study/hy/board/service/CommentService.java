package com.study.hy.board.service;

import com.study.hy.board.domain.Board;
import com.study.hy.board.domain.Comment;
import com.study.hy.board.dto.CommentRequestDto;
import com.study.hy.board.repository.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    /**
     * 댓글 작성 서비스
     *
     * @param request CommentRequestDto
     * @return Integer
     */
    public Integer createComment(CommentRequestDto request) {
        return commentMapper.insertOne(request);
    }


    /**
     * 댓글 목록 조회 서비스
     *
     * @param boardNo int 게시글 PK
     * @return List
     */
    public List<Comment> getCommentList(int boardNo) {
        return commentMapper.selectAll(boardNo);
    }

    /**
     * 댓글 삭제 서비스
     *
     * @param commentNo int
     * @return Integer
     */
    public Integer removeComment(int commentNo) {
        return commentMapper.deleteOne(commentNo);
    }
}
