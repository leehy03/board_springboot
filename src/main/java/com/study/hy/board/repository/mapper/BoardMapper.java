package com.study.hy.board.repository.mapper;

import com.study.hy.board.domain.Board;
import com.study.hy.board.dto.BoardRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    List<Board> selectAll(String keyword);
    Board selectOne(int boardNo);
    Integer insertOne(BoardRequestDto request);

}
