package com.tpa.toyproject_api.Board.Data.Repository;

import com.tpa.toyproject_api.Board.Data.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Post, Integer> {
    Post getByPid(int pid);
}
