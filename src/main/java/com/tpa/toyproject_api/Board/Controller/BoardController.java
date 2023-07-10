package com.tpa.toyproject_api.Board.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/board")
@RestController
public class BoardController {
    @PostMapping("/test")
    public String test() {
        return "test";
    }
}
