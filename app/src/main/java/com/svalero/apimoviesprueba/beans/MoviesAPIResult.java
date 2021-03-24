package com.svalero.apimoviesprueba.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesAPIResult {
    private Integer page;
    private List<Movie> results;
    private Integer total_pages;
    private Integer total_results;
}
