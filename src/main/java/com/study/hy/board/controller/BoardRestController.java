package com.study.hy.board.controller;

import com.study.hy.board.domain.Board;
import com.study.hy.board.dto.BoardRequestDto;
import com.study.hy.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardRestController {
    private final BoardService boardService;

    @GetMapping("/boards/list")
    public ResponseEntity<?> getBoardList(BoardRequestDto request) {
        return ResponseEntity.ok().build();
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

    @PostMapping("/boards/")
    public ResponseEntity<?> createBoard(@RequestBody BoardRequestDto request) {
        int result = boardService.createBoard(request);
        return ResponseEntity.ok().body(result);
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
