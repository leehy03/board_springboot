package com.study.hy.board.repository.mapper;

import com.study.hy.board.domain.Board;
import com.study.hy.board.dto.BoardRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    /**
     * BoardMapper.selectAll
     *
     * @param keyword String
     * @param type String
     * @return List
     */
    List<Board> selectAll(String keyword, String type);

    /**
     * BoardMapper.selectOne
     *
     * @param boardNo int
     * @return Board
     */
    Board selectOne(int boardNo);

    /**
     * BoardMapper.updateView
     *
     * @param boardNo int
     * @return Integer
     */
    Integer updateView(int boardNo);


    /**
     * BoardMapper.insertOne
     *
     * @param request BoardRequestDto
     * @return Integer
     */
    Integer insertOne(BoardRequestDto request);

    /**
     * BoardMapper.updateOne
     *
     * @param request BoardRequestDto
     * @return Integer
     */
    Integer updateOne(BoardRequestDto request);

    /**
     * BoardMapper.deleteOne
     *
     * @param boardNo int
     * @return Integer
     */
    Integer deleteOne(int boardNo);

}
