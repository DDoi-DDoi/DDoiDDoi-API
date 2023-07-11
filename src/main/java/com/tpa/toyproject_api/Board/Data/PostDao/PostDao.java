package com.tpa.toyproject_api.Board.Data.PostDao;

import com.tpa.toyproject_api.Board.Data.Entity.Post;

public interface PostDao {
    Post insertPost(Post post);

    Post selectPost(int postId);

    Post updatePost(int postId, int thumsUp, int views) throws Exception;

    void deletePost(int postId) throws Exception;
}
