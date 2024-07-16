package com.study.hy.board.repository.mapper;

import com.study.hy.board.model.entity.Comment;
import com.study.hy.board.model.dto.CommentRequestDto;
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
     * @param offset int
     * @param pageSize int
     * @return List
     */
    List<Comment> selectAll(int boardNo, int offset, int pageSize);

    /**
     * CommentMapper.deleteOne
     *
     * @param commentNo int
     * @return Integer
     */
    Integer deleteOne(int commentNo);

    /**
     * CommentMapper.countAll
     *
     * @param boardNo int
     * @return Integer
     */
    int countAll(int boardNo);
}
