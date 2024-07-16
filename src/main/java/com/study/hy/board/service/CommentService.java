package com.study.hy.board.service;

import com.study.hy.board.model.entity.Comment;
import com.study.hy.board.model.dto.CommentRequestDto;
import com.study.hy.board.model.vo.PageVo;
import com.study.hy.board.repository.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.study.hy.board.util.PageUtil.getOffset;

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
     * @param boardNo     int 게시글 PK
     * @param currentPage int 조회 페이지 (default value = 1)
     * @param pageSize    int 페이지사이즈
     * @return PageVo
     */
    public PageVo getCommentList(int boardNo, int currentPage, int pageSize) {
        int totalCount = commentMapper.countAll(boardNo);
        int totalPage = totalCount / pageSize;
        int offset = getOffset(currentPage, pageSize);
        List<Comment> contents = commentMapper.selectAll(boardNo, offset, pageSize);

        return new PageVo(totalCount, totalPage, currentPage, contents);
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
