package com.tpa.toyproject_api.Board.Service;

import com.tpa.toyproject_api.Board.Data.Dto.ChangePostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostResponseDto;

public interface PostService {
    PostResponseDto getPost(int pid);

    PostResponseDto savePost(PostDto postDto);

    PostResponseDto changePost(ChangePostDto changePostDto) throws Exception;

    void deletePost(int pid) throws Exception;
}
