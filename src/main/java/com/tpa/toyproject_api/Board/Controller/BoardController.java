package com.tpa.toyproject_api.Board.Controller;

import com.tpa.toyproject_api.Board.Data.Dto.ChangePostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostResponseDto;
import com.tpa.toyproject_api.Board.Service.PostService;
import com.tpa.toyproject_api.Board.Service.impl.PostServiceImpl;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RestController
public class BoardController {
    private final PostServiceImpl postService;

    @Autowired
    public BoardController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/board")
    public String showBoard() {
        return "ok";
    }

    @GetMapping("/post")
    public ResponseEntity<PostResponseDto> getPost(int pid) {
        PostResponseDto postResponseDto = postService.getPost(pid);

        if (postResponseDto == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(postResponseDto);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostDto postDto) {
        PostResponseDto postResponseDto = postService.savePost(postDto);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PutMapping("/post")
    public ResponseEntity<PostResponseDto> updatePost(
            @RequestBody ChangePostDto changePostDto) throws Exception {
        PostResponseDto postResponseDto = postService.changePost(changePostDto);

        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @DeleteMapping("/post")
    public ResponseEntity<String> deletePost(int pid) throws Exception {
        postService.deletePost(pid);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
