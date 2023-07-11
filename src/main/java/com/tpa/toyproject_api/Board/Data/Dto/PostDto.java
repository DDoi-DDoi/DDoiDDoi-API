package com.tpa.toyproject_api.Board.Data.Dto;

import lombok.Data;

@Data
public class PostDto {
    int postId;
    String id;
    String title;
    String text;
    int views;
    int thumsUp;
}
