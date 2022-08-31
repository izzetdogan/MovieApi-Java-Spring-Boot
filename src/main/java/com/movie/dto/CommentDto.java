package com.movie.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentDto {
    private Long id;
    @NotBlank
    private String content;

}
