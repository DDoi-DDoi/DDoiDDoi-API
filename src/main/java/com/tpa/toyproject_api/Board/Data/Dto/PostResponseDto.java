package com.tpa.toyproject_api.Board.Data.Dto;

import lombok.Data;

@Data
public class PostResponseDto {
    int pid;
    String id;
    String title;
    String text;
    int views;
    int up;
}
