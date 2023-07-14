package com.tpa.toyproject_api.Board.Data.Dto;


import lombok.Data;

@Data
public class ChangePostDto {
    private int pid;
    /*
    1: id
    2: title
    3: text
    4: views
    5: up
    */
    private int func;

    private String content;
}
