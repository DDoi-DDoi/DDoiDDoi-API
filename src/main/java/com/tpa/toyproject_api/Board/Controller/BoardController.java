package com.tpa.toyproject_api.Board.Controller;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RestController
public class BoardController {
    @GetMapping("/board")
    public String showBoard() {
        return "ok";
    }

    @GetMapping("/post")
    public String getPost() {
        return "ok";
    }

    @PostMapping("/post")
    public String postPost() {
        return "ok";
    }

    @PostMapping("/post")
    public String putPost() {
        return "ok";
    }

    @DeleteMapping("/post")
    public String deletePost() {
        return "ok";
    }
}
