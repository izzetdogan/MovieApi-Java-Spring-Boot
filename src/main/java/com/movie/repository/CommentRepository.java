package com.movie.repository;

import com.movie.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
   // List<Comment> findByUserIdAndMovieId(Long userId, Long postId);

    // List<Comment> findByUserId(Long userId);

    // List<Comment> findByMovieId(Long postId);
}
