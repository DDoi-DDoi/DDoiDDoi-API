package com.tpa.toyproject_api.Board.Data.PostDao;

import com.tpa.toyproject_api.Board.Data.Dto.ChangePostDto;
import com.tpa.toyproject_api.Board.Data.Entity.Post;

public interface PostDao {
    Post insertPost(Post post);

    Post selectPost(int pid);

    Post updatePost(ChangePostDto changePostDto) throws Exception;

    void deletePost(int pid) throws Exception;
}
