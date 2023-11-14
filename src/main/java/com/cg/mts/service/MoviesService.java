package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cg.mts.dto.MovieDTO;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.pojo.Movie;

public interface MoviesService {
	 
	public MovieDTO addMovie(MovieDTO movie) throws MovieNotFoundException;
 
	public MovieDTO removeMovie(int movieid) throws MovieNotFoundException;
	
	public MovieDTO updateMovie(MovieDTO movie) throws MovieNotFoundException;
	
	public MovieDTO addMovieToShow(MovieDTO movie, Integer showId) throws MovieNotFoundException;
 
	public MovieDTO viewMovie(int movieid)throws MovieNotFoundException;
 
	public List<MovieDTO> viewMovieList() throws MovieNotFoundException;
 
	public List<MovieDTO> viewMovieList(int theatreid);
 
	public List<MovieDTO> viewMovieList(LocalDate date);

	
}
 