package com.tpa.toyproject_api.Board.Service;

import com.tpa.toyproject_api.Board.Data.Dto.PostDto;

public interface PostService {
    PostDto getPost(int postId);
    PostDto savePost(int postId, String id, String text);
}
