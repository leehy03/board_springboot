package com.study.hy.board.repository.mapper;

import com.study.hy.board.domain.Comment;
import com.study.hy.board.dto.BoardRequestDto;
import com.study.hy.board.dto.CommentRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * CommentMapper.insertOne
     *
     * @param request CommentRequestDto
     * @return Integer
     */
    Integer insertOne(CommentRequestDto request);

    /**
     * CommentMapper.selectAll
     *
     * @param boardNo int
     * @return List
     */
    List<Comment> selectAll(int boardNo);

    /**
     * CommentMapper.deleteOne
     *
     * @param commentNo int
     * @return Integer
     */
    Integer deleteOne(int commentNo);
}
