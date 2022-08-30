package com.movie.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class MovieYearDto {
    private Integer id;
    @Min(value = 1900, message = "There must be at least {value} test{value > 1 ? 's' : ''} in the test case")
    private int year;
}
