package com.tpa.toyproject_api.Board.Service.impl;

import com.tpa.toyproject_api.Board.Data.Dto.PostDto;
import com.tpa.toyproject_api.Board.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostDto postDto;

    @Autowired
    public PostServiceImpl(PostDto postDto) {
        this.postDto = postDto;
    }

    @Override
    public PostDto getPost(int postId) {
        return null;
    }

    @Override
    public PostDto savePost(int postId, String id, String text) {
        return null;
    }
}
