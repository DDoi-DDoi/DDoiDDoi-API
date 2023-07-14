package com.tpa.toyproject_api.Board.Data.Repository;

import com.tpa.toyproject_api.Board.Data.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Post, Integer> {
    Post getByPid(int pid);
    Optional<Post> findByPid(int pid);
    void deleteByPid(int pid);
}
