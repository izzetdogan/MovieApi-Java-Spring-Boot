package com.movie.controller;

import com.movie.dto.MovieYearDto;
import com.movie.service.MovieYearService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie/years")
public class MovieYearController {
    private final MovieYearService movieYearService;

    public MovieYearController(MovieYearService movieYearService) {
        this.movieYearService = movieYearService;
    }

    //Get All YEar
    @GetMapping
    public ResponseEntity<List<MovieYearDto>> getAllYear(){
        return new ResponseEntity<List<MovieYearDto>>(this.movieYearService.getAllYear(),HttpStatus.OK);
    }

    //GetYearBy ıd
    @GetMapping("{id}")
    public ResponseEntity<MovieYearDto> getYearById(@PathVariable Integer id){
        return new ResponseEntity<MovieYearDto>(this.movieYearService.getYearById(id),HttpStatus.OK);
    }

    //Create Movie Year
    @PostMapping()
    public ResponseEntity<MovieYearDto> createMovieYear(@Valid  @RequestBody MovieYearDto movieYearDto){
        return new ResponseEntity<>(this.movieYearService.createMovieYear(movieYearDto),HttpStatus.CREATED);
    }

    //Update MovieYear ByID
    @PutMapping("/{id}")
    public ResponseEntity<MovieYearDto> updateMovieYear(@PathVariable Integer id, @Valid @RequestBody MovieYearDto request){
        return new ResponseEntity<MovieYearDto>(this.movieYearService.updateMovieYear(id,request),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoviYear(@PathVariable Integer id){
        this.movieYearService.deleteMovieYear(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
