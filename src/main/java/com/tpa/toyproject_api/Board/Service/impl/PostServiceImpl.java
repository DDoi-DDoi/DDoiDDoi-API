package com.tpa.toyproject_api.Board.Service.impl;

import com.tpa.toyproject_api.Board.Data.Dto.PostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostResponseDto;
import com.tpa.toyproject_api.Board.Data.Entity.Post;
import com.tpa.toyproject_api.Board.Data.PostDao.PostDao;
import com.tpa.toyproject_api.Board.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public PostResponseDto getPost(int postId) {
        Post post = postDao.selectPost(postId);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setPostId(post.getPostId());
        postResponseDto.setId(post.getId());
        postResponseDto.setText(post.getText());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setViews(post.getViews());
        postResponseDto.setThumsUp(post.getThumsUp());

        return postResponseDto;
    }

    @Override
    public PostResponseDto savePost(PostDto postDto) {
        Post post = new Post();
        postDto.setPostId(post.getPostId());
        postDto.setId(post.getId());
        postDto.setText(post.getText());
        postDto.setTitle(post.getTitle());
        postDto.setViews(post.getViews());
        postDto.setThumsUp(post.getThumsUp());

        Post savedPost = postDao.insertPost(post);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setPostId(savedPost.getPostId());
        postResponseDto.setId(savedPost.getId());
        postResponseDto.setText(savedPost.getText());
        postResponseDto.setTitle(savedPost.getTitle());
        postResponseDto.setViews(savedPost.getViews());
        postResponseDto.setThumsUp(savedPost.getThumsUp());

        return postResponseDto;
    }
}
