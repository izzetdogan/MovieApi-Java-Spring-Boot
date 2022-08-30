package com.movie.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "movieYear")
public class MovieYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "movie_year" , nullable = false)
    private int year ;


}
