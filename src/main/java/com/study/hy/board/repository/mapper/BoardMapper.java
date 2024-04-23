package com.study.hy.board.repository.mapper;

import com.study.hy.board.domain.Board;
import com.study.hy.board.dto.BoardRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    Board selectOne(int boardNo);
    int insertOne(BoardRequestDto requestDto);
}
