package com.study.hy.board.controller;

import com.study.hy.board.model.dto.CommentRequestDto;
import com.study.hy.board.model.vo.PageVo;
import com.study.hy.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    /**
     * 댓글 목록 조회 API
     *
     * @param currentPage int 현재페이지
     * @param pageSize    int 페이지 사이즈
     * @param boardNo     int 게시글 PK
     * @return ResponseEntity
     */
    @GetMapping("/comments/list")
    public ResponseEntity<?> getCommentList(
            @RequestParam("no") int boardNo,
            @RequestParam("currentPage") int currentPage,
            @RequestParam("pageSize") int pageSize) {
        log.info("boardNo is {} ", boardNo);
        PageVo result = commentService.getCommentList(boardNo, currentPage, pageSize);
        return ResponseEntity.ok().body(result);
    }

    /**
     * 댓글 작성 API
     *
     * @param request CommentRequestDto
     * @return ResponseEntity 성공 시 1, 실패 시 null 반환
     */
    @PostMapping("/comments")
    public ResponseEntity<?> createComment(@RequestBody CommentRequestDto request) {
        log.info("request is {}", request);
        Integer insertedCount = commentService.createComment(request);
        return ResponseEntity.ok().body(insertedCount);
    }

    /**
     * 댓글 삭제 API
     *
     * @param commentNo CommentRequestDto
     * @return ResponseEntity
     */
    @DeleteMapping("/comments")
    public ResponseEntity<?> removeComment(@RequestParam("no") int commentNo) {
        log.info("commentNo is {} ", commentNo);
        Integer deletedCount = commentService.removeComment(commentNo);
        return ResponseEntity.ok().body(deletedCount);
    }
}
