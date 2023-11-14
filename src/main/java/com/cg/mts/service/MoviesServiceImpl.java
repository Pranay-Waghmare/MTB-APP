package com.cg.mts.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
//import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.mts.dto.MovieDTO;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.pojo.Movie;
import com.cg.mts.pojo.Show;
import com.cg.mts.repoImpl.QueryClass;
import com.cg.mts.repository.MoviesRepository;
import com.cg.mts.repository.ShowRepository;
import com.cg.mts.repository.TheatreRepository;


import org.springframework.util.StringUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Base64;

@Service
public class MoviesServiceImpl implements MoviesService {

	    @Autowired
		private MoviesRepository moviesrepository;
	 
		@Autowired
		private ShowRepository showrepository;
	 
		@Autowired
		private ModelMapper modelMapper;

		@Override
		public MovieDTO addMovie(MovieDTO movieDTO) throws MovieNotFoundException {
		    if (movieDTO != null) {
		        if (moviesrepository.existsById(movieDTO.getMovieId())) {
		            throw new MovieNotFoundException("Movie with this id already exists");
		        } else {
		            ModelMapper modelMapper = new ModelMapper();
		            Movie movie = modelMapper.map(movieDTO, Movie.class);

		            moviesrepository.saveAndFlush(movie);
		        }
		    }
		    return movieDTO;
		}


		@Override
		public MovieDTO removeMovie(int movieId) throws MovieNotFoundException {
		    Movie movie = moviesrepository.findById(movieId)
		            .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + movieId));

		    List<Show> shows = showrepository.findAll();
		    for (Show show : shows) {
		        if (show.getMovie() != null && show.getMovie().getMovieId() == movieId) {
		            show.setMovie(null);
		        }
		    }

		    moviesrepository.delete(movie);

		    ModelMapper modelMapper = new ModelMapper();
		    return modelMapper.map(movie, MovieDTO.class);
		}

		
		@Override
		public MovieDTO updateMovie(MovieDTO movieDTO) {
		    ModelMapper modelMapper = new ModelMapper();
		    Movie movieToUpdate = modelMapper.map(movieDTO, Movie.class);

		    // Assuming you have validation or additional logic before updating
		    // ...

		    Movie updatedMovie = moviesrepository.saveAndFlush(movieToUpdate);

		    return modelMapper.map(updatedMovie, MovieDTO.class);
		}


		@Override
		public MovieDTO addMovieToShow(MovieDTO movieDTO, Integer showId) {
		    ModelMapper modelMapper = new ModelMapper();
		    Movie movie = modelMapper.map(movieDTO, Movie.class);

		    Show show = (showId != null) ? showrepository.getOne(showId) : null;
		    movie.setShow(show);

		    moviesrepository.saveAndFlush(movie);

		    return modelMapper.map(movie, MovieDTO.class);
		}


		@Override
		public MovieDTO viewMovie(int movieId) throws MovieNotFoundException {
		    Movie movie = getMovieById(movieId);

		    if (movie != null) {
		        ModelMapper modelMapper = new ModelMapper();
		        //throw new MovieNotFoundException("Movie not found with id: " + movieId);
		        return modelMapper.map(movie, MovieDTO.class);
		    }
		    return null; // or throw an exception, depending on your requirements
		}

		private Movie getMovieById(int movieId) throws MovieNotFoundException {
		    Movie movie = moviesrepository.findById(movieId).orElse(null);
		    if (movie == null) {
		        // Alternatively, you can throw an exception here if needed
		        throw new MovieNotFoundException("Movie not found with id: " + movieId);
		    }
		    return movie;
		}



		@Override
		public List<MovieDTO> viewMovieList() throws MovieNotFoundException {
		    List<Movie> movieList = moviesrepository.findAll();

		    if (movieList.isEmpty()) {
		        throw new MovieNotFoundException("Movies don't exist");
		    }

		    ModelMapper modelMapper = new ModelMapper();
		    Type listType = new TypeToken<List<MovieDTO>>() {}.getType();
		    return modelMapper.map(movieList, listType);
		}


		@Override
		public List<MovieDTO> viewMovieList(int theatreId) {
		    List<Movie> movies = new ArrayList<>();
		    List<Show> shows = showrepository.findAll();
		    Set<Integer> showIds = new HashSet<>();
		    for (Show s : shows) {
		        if (s.getTheatre().getTheatreId() == theatreId) {
		            showIds.add(s.getShowId());
		        }
		    }
		    ModelMapper modelMapper = new ModelMapper();
		    Type listType = new TypeToken<List<MovieDTO>>() {}.getType();
		    
		    List<MovieDTO> movieDTOs = new ArrayList<>();
		    for (Integer id : showIds) {
		        Movie movie = showrepository.getOne(id).getMovie();
		        movies.add(movie);
		        movieDTOs.add(modelMapper.map(movie, MovieDTO.class));
		    }
		    
		    return movieDTOs;
		}

		@Override
		public List<MovieDTO> viewMovieList(LocalDate date) {
		    List<Movie> movies = moviesrepository.findAll();
		    List<MovieDTO> movieDTOs = new ArrayList<>();
		    
		    ModelMapper modelMapper = new ModelMapper();
		    Type listType = new TypeToken<List<MovieDTO>>() {}.getType();
		    
		    for (Movie movie : movies) {
		        if (movie.getMovieDate() != null && movie.getMovieDate().isEqual(date)) {
		            movieDTOs.add(modelMapper.map(movie, MovieDTO.class));
		        }
		    }
		    
		    return movieDTOs;
		}

}
