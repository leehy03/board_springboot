package com.study.hy.board.controller;

import com.study.hy.board.model.entity.Board;
import com.study.hy.board.model.dto.BoardRequestDto;
import com.study.hy.board.model.vo.PageVo;
import com.study.hy.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardRestController {
    private final BoardService boardService;

    /**
     * 게시글 목록 조회 API
     *
     * @param currentPage int 현재페이지
     * @param pageSize    int 페이지 사이즈
     * @param keyword     String 검색 키워드
     * @param type        String 검색키워드 타입 (title or author)
     * @return ResponseEntity
     */
    @GetMapping("/boards/list")
    public ResponseEntity<?> getBoardList(
            @RequestParam(required = false, value = "keyword") String keyword,
            @RequestParam(required = false, value = "type") String type,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize
            ) {
        PageVo result = boardService.getBoardList(currentPage, pageSize, keyword, type);
        return ResponseEntity.ok().body(result);
    }

    /**
     * 게시글 상세 조회 API
     *
     * @param boardNo   int 게시글 PK
     * @param departure String 조회수 증가 메서드 호출 분기 처리를 위한 변수
     * @return ResponseEntity
     */
    @GetMapping("/boards")
    public ResponseEntity<?> getBoard(@RequestParam("no") int boardNo, @RequestParam("departure") String departure) {
        log.info("boardNo is {} from {}", boardNo, departure);
        Board board = boardService.getBoard(boardNo, departure);
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
        log.info("request is {}", request);
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
        log.info("request is {}", request);
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
