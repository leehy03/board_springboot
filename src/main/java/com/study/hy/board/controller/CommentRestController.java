package com.study.hy.board.controller;

import com.study.hy.board.domain.Comment;
import com.study.hy.board.dto.CommentRequestDto;
import com.study.hy.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    /**
     * 댓글 목록 조회 API
     *
     * @param boardNo int 게시글 PK
     * @return ResponseEntity
     */
    @GetMapping("/comments/list")
    public ResponseEntity<?> getCommentList(@RequestParam("no") int boardNo) {
        log.info("boardNo is {} ", boardNo);
        List<Comment> commentList = commentService.getCommentList(boardNo);
        return ResponseEntity.ok().body(commentList);
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
