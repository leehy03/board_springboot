package com.study.hy.board.controller;

import com.study.hy.board.domain.Board;
import com.study.hy.board.dto.BoardRequestDto;
import com.study.hy.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardRestController {
    private final BoardService boardService;

    /**
     * 게시글 목록 조회 API
     *
     * @param keyword String 제목 포함 검색 키워드
     * @return ResponseEntity
     */
    @GetMapping("/boards/list")
    public ResponseEntity<?> getBoardList(@RequestParam(required = false, value = "keyword") String keyword) {
        List<Board> boardList = boardService.getBoardList(keyword);
        return ResponseEntity.ok().body(boardList);
    }

    /**
     * 게시글 상세 조회 API
     *
     * @param boardNo int 게시글 PK
     * @return ResponseEntity
     */
    @GetMapping("/boards")
    public ResponseEntity<?> getBoard(@RequestParam("no") int boardNo) {
        Board board = boardService.getBoard(boardNo);
        return ResponseEntity.ok().body(board);
    }

    /**
     * 게시글 작성 API
     *
     * @param request BoardRequestDto
     * @return Integer
     */
    @PostMapping("/boards")
    public ResponseEntity<?> createBoard(@RequestBody BoardRequestDto request) {
        Integer insertedCount = boardService.createBoard(request);
        return ResponseEntity.ok().body(insertedCount);
    }

    @PutMapping("/boards")
    public ResponseEntity<?> updateBoard(BoardRequestDto request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/boards")
    public ResponseEntity<?> removeBoard(BoardRequestDto request) {
        return ResponseEntity.ok().build();
    }
}
