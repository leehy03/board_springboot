package com.study.hy.board.service;

import com.study.hy.board.domain.Board;
import com.study.hy.board.dto.BoardRequestDto;
import com.study.hy.board.repository.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    /**
     * 게시글 목록 조회 서비스
     *
     * @param keyword string 게시글
     * @return List<Board>
     */
    public List<Board> getBoardList(String keyword) {
        return boardMapper.selectAll(keyword);
    }

    /**
     * 게시글 상세 조회 서비스
     *
     * @param boardNo int 게시글 PK
     * @return Board
     */
    public Board getBoard(int boardNo) {
        return boardMapper.selectOne(boardNo);
    }

    /**
     * 게시글 작성 서비스
     *
     * @param request BoardRequestDto
     * @return Integer
     */
    public Integer createBoard(BoardRequestDto request) {
        return boardMapper.insertOne(request);
    }
}
