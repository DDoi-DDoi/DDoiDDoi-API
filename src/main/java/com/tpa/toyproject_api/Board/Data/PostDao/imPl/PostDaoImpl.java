package com.tpa.toyproject_api.Board.Data.PostDao.imPl;

import com.tpa.toyproject_api.Board.Data.Entity.Post;
import com.tpa.toyproject_api.Board.Data.PostDao.PostDao;
import com.tpa.toyproject_api.Board.Data.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostDaoImpl implements PostDao {
    private final BoardRepository boardRepository;

    @Autowired
    public PostDaoImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Post insertPost(Post post) {
        Post savedPost = boardRepository.save(post);

        return savedPost;
    }

    @Override
    public Post selectPost(int pid) {
        Post selectedPost = boardRepository.getByPid(pid);

        return selectedPost;
    }

    @Override
    public Post updatePost(int pid, int Up, int views) throws Exception {
        Optional<Post> selectedPost = boardRepository.findById(pid);

        Post updatePost;
        if (selectedPost.isPresent()) {
            Post post = selectedPost.get();

            post.setUp(Up);
            post.setViews(views);

            updatePost = boardRepository.save(post);
        } else {
            throw new Exception();
        }
        return updatePost;
    }

    @Override
    public void deletePost(int pid) throws Exception {
        Optional<Post> selectedPost = boardRepository.findById(pid);

        if (selectedPost.isPresent()) {
            Post post = selectedPost.get();

            boardRepository.delete(post);
        } else {
            throw new Exception();
        }
    }
}
