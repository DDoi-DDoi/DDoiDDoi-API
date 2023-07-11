package com.tpa.toyproject_api.Board.Data.PostDao;

import com.tpa.toyproject_api.Board.Data.Entity.Post;

public interface PostDao {
    Post insertPost(Post post);

    Post selectPost(int pid);

    Post updatePost(int pid, int up, int views) throws Exception;

    void deletePost(int pid) throws Exception;
}
