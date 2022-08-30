package com.movie.repository;

import com.movie.model.MovieYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieYearRepository extends JpaRepository<MovieYear,Integer> {
}
