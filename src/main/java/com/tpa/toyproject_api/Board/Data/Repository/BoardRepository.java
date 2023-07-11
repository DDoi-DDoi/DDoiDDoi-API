package com.tpa.toyproject_api.Board.Data.Repository;

import com.tpa.toyproject_api.Board.Data.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Post, Integer> {

}
