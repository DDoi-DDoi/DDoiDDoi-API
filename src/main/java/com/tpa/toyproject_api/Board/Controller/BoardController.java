package com.tpa.toyproject_api.Board.Controller;

import com.tpa.toyproject_api.Board.Data.Dto.PostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostResponseDto;
import com.tpa.toyproject_api.Board.Service.PostService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RestController
public class BoardController {
    private final PostService postService;

    @Autowired
    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/board")
    public String showBoard() {
        return "ok";
    }

    @GetMapping("/post")
    public ResponseEntity<PostResponseDto> getPost(int pid) {
        PostResponseDto postResponseDto = postService.getPost(pid);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostDto postDto) {
        PostResponseDto postResponseDto = postService.savePost(postDto);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PutMapping("/post")
    public String updatePost() {

        return "ok";
    }

    @DeleteMapping("/post")
    public String deletePost() {

        return "ok";
    }
}
