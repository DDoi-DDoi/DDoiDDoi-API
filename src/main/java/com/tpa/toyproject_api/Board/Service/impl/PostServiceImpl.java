package com.tpa.toyproject_api.Board.Service.impl;

import com.tpa.toyproject_api.Board.Data.Dto.ChangePostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostDto;
import com.tpa.toyproject_api.Board.Data.Dto.PostResponseDto;
import com.tpa.toyproject_api.Board.Data.Entity.Post;
import com.tpa.toyproject_api.Board.Data.PostDao.imPl.PostDaoImpl;
import com.tpa.toyproject_api.Board.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostDaoImpl postDao;

    @Autowired
    public PostServiceImpl(PostDaoImpl postDao) {
        this.postDao = postDao;
    }

    @Override
    public PostResponseDto getPost(int pid) {
        Post post = postDao.selectPost(pid);

        if (post == null) {
            // 게시물이 없는 경우에 대한 처리
            return null;
        }

        // 기존 코드와 동일한 내용
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setPid(post.getPid());
        postResponseDto.setId(post.getId());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setText(post.getText());
        postResponseDto.setViews(post.getViews());
        postResponseDto.setUp(post.getUp());

        return postResponseDto;
    }

    @Override
    public PostResponseDto savePost(PostDto postDto) {
        Post post = new Post();

        post.setPid(postDto.getPid());
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());
        post.setViews(postDto.getViews());
        post.setUp(postDto.getUp());

        Post savedPost = postDao.insertPost(post);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setPid(savedPost.getPid());
        postResponseDto.setId(savedPost.getId());
        postResponseDto.setTitle(savedPost.getTitle());
        postResponseDto.setText(savedPost.getText());
        postResponseDto.setViews(savedPost.getViews());
        postResponseDto.setUp(savedPost.getUp());

        return postResponseDto;
    }

    @Override
    public PostResponseDto changePost(ChangePostDto changePostDto) throws Exception {
        Post changedPost = postDao.updatePost(changePostDto);

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setPid(changedPost.getPid());
        postResponseDto.setId(changedPost.getId());
        postResponseDto.setTitle(changedPost.getTitle());
        postResponseDto.setText(changedPost.getText());
        postResponseDto.setViews(changedPost.getViews());
        postResponseDto.setUp(changedPost.getUp());
        return postResponseDto;
    }

    @Override
    public void deletePost(int pid) throws Exception {
        postDao.deletePost(pid);
    }
}
