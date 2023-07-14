package com.tpa.toyproject_api.Board.Data.PostDao.imPl;

import com.tpa.toyproject_api.Board.Data.Dto.ChangePostDto;
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
    public Post updatePost(ChangePostDto changePostDto) throws Exception {
        Optional<Post> selectedPost = boardRepository.findByPid(changePostDto.getPid());

        Post updatePost;
        if (selectedPost.isPresent()) {
            Post post = selectedPost.get();
    /*
    1: title
    2: text
    3: views
    4: up
    */
            switch (changePostDto.getFunc()) {
                case 1:
                    post.setTitle(changePostDto.getContent());
                    break;
                case 2:
                    post.setText(changePostDto.getContent());
                    break;
                case 3:
                    post.setViews(post.getViews() + 1);
                    break;
                case 4:
                    post.setUp(post.getUp() + 1);
                    break;
            }
            updatePost = boardRepository.save(post);
        } else {
            throw new Exception();
        }
        return updatePost;
    }

    /*    @Override
        public Post updatePost(int pid, String title, String text, int up, int views) throws Exception {
            Optional<Post> selectedPost = boardRepository.findByPid(pid);

            Post updatePost;
            if (selectedPost.isPresent()) {
                Post post = selectedPost.get();

                post.setTitle(title);
                post.setText(text);
                post.setUp(up);
                post.setViews(views);

                updatePost = boardRepository.save(post);
            } else {
                throw new Exception();
            }
            return updatePost;
        }*/
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
