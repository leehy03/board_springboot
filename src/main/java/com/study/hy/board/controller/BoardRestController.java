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
     * @return ResponseEntity 성공 시 1, 실패 시 null 반환
     */
    @PostMapping("/boards")
    public ResponseEntity<?> createBoard(@RequestBody BoardRequestDto request) {
        Integer insertedCount = boardService.createBoard(request);
        return ResponseEntity.ok().body(insertedCount);
    }

    /**
     * 게시글 수정 API
     *
     * @param request BoardRequestDto
     * @return ResponseEntity
     */
    @PutMapping("/boards")
    public ResponseEntity<?> modifyBoard(@RequestBody BoardRequestDto request) {
        Integer updatedCount = boardService.modifyBoard(request);
        return ResponseEntity.ok().body(updatedCount);
    }

    /**
     * 게시글 삭제 API
     *
     * @param boardNo BoardRequestDto
     * @return ResponseEntity
     */
    @DeleteMapping("/boards")
    public ResponseEntity<?> removeBoard(@RequestParam("no") int boardNo) {
        Integer deletedCount = boardService.removeBoard(boardNo);
        return ResponseEntity.ok().body(deletedCount);
    }
}
