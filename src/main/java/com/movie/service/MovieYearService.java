package com.movie.service;

import com.movie.dto.MovieYearDto;
import com.movie.model.Category;
import com.movie.model.MovieYear;
import com.movie.repository.MovieYearRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieYearService {

    private final MovieYearRepository movieYearRepository;

    public MovieYearService(MovieYearRepository movieYearRepository) {
        this.movieYearRepository = movieYearRepository;
    }

    //Get All YEar
    public List<MovieYearDto> getAllYear(){
        List<MovieYear> movieYears = movieYearRepository.findAll();
        List<MovieYearDto> movieYearDtoList = movieYears.stream()
                .map((mvy)-> this.toYearDto(mvy)).collect(Collectors.toList());
        return movieYearDtoList;

    }

    // Get Year By ID
    public MovieYearDto getYearById(Integer id){
        MovieYear movieYear = this.movieYearRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no  id"+id));
        return this.toYearDto(movieYear);
    }

    //Create Movie Year
    public MovieYearDto createMovieYear(MovieYearDto movieYearDto){
        MovieYear movieYear = this.movieYearRepository.save(this.toYear(movieYearDto));
        MovieYearDto savedOne = this.toYearDto(movieYear);
        return savedOne;
    }

    //Update Movie Year By ID
    public MovieYearDto updateMovieYear(Integer id, MovieYearDto movieYearDto){
        MovieYear movieYear = this.movieYearRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no id"+id));
        movieYear.setYear(movieYearDto.getYear());
        MovieYear updatedOne = this.movieYearRepository.save(movieYear);
        return this.toYearDto(updatedOne);
    }

    //Delete MovieYear By ID
    public void deleteMovieYear(Integer id){
        MovieYear movieYear = this.movieYearRepository.findById(id).orElseThrow(() -> new RuntimeException("ther is no id" +id));
        this.movieYearRepository.delete(movieYear);
    }

    ///Convert

    private MovieYear toYear(MovieYearDto movieYearDto){
        MovieYear movieYear = new MovieYear();
        movieYear.setYear(movieYearDto.getYear());
        movieYear.setId(movieYearDto.getId());
        return movieYear;

    }

    private MovieYearDto toYearDto(MovieYear movieYear){
        MovieYearDto movieYearDto = new MovieYearDto();
        movieYearDto.setId(movieYear.getId());
        movieYearDto.setYear(movieYear.getYear());
        return  movieYearDto;
    }
}
