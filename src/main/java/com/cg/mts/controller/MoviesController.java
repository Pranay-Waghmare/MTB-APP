package com.cg.mts.controller;
 
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
 
import com.cg.mts.service.MoviesService;
import com.cg.mts.dto.MovieDTO;
import com.cg.mts.exception.MovieNotFoundException;
//import com.cg.mts.pojo.Movie;


   @CrossOrigin(origins = "http://localhost:4200")
   @RestController
   @RequestMapping("/movies")
   public class MoviesController {
 
	Logger logger = LoggerFactory.getLogger(MoviesController.class);
	
	@Autowired
	private MoviesService moviesService;
 
	@Autowired
	private ModelMapper modelMapper;
	    
	    
         @PostMapping("/add")  	
         public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO)
        		 throws MovieNotFoundException,IOException {
             try {
                 MovieDTO addedMovieDTO = moviesService.addMovie(movieDTO);
                 return new ResponseEntity<>(addedMovieDTO, HttpStatus.CREATED);
             } catch (MovieNotFoundException e) {
            	 
                 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
             }
         }
         
         @PutMapping("/update")
         public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movieDTO) {
             ResponseEntity<MovieDTO> response;
             if (movieDTO == null) {
                 response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
             } else {
                 try {
                     MovieDTO updatedMovieDTO = moviesService.updateMovie(movieDTO);
                     response = new ResponseEntity<>(updatedMovieDTO, HttpStatus.OK);
                     logger.info("-------Movie Updated Successfully---------");
                 } catch (MovieNotFoundException e) {
             
                     response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
                 }
             }
             return response;
         }
         
         @PutMapping("/map")
         public ResponseEntity<MovieDTO> addToShow(@RequestBody MovieDTO movieDTO, @RequestParam(required = false) Integer showId) {
             ResponseEntity<MovieDTO> response;
             if (movieDTO == null) {
                 response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
             } else {
                 try {
                     MovieDTO updatedMovieDTO = moviesService.addMovieToShow(movieDTO, showId);
                     response = new ResponseEntity<>(updatedMovieDTO, HttpStatus.OK);
                     logger.info("-------Movie Updated Successfully---------");
                 } catch (MovieNotFoundException e) {
                     response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
                 }
             }
             return response;
         }
         
         @GetMapping("findall")
         public ResponseEntity<List<MovieDTO>> viewMovieList() {
             try {
                 List<MovieDTO> movieDTOs = moviesService.viewMovieList()
                         .stream()
                         .map(movie -> modelMapper.map(movie, MovieDTO.class))
                         .collect(Collectors.toList());

                 logger.info("-------Movie List Fetched---------");
                 return ResponseEntity.ok(movieDTOs);
             } catch (MovieNotFoundException e) {
             
                 return ResponseEntity.status(404).build();
             }
         }
         
         @GetMapping("/viewMovie/{movieId}")
         public ResponseEntity<MovieDTO> viewMovie(@PathVariable int movieId) {
             try {
                 MovieDTO movieDTO = modelMapper.map(moviesService.viewMovie(movieId), MovieDTO.class);
                 logger.info("-------Movie With Movie id " + movieId + " Found---------");
                 return ResponseEntity.ok(movieDTO);
             } catch (MovieNotFoundException e) {
               
                 return ResponseEntity.status(404).build();
             }
         }
         
         @DeleteMapping("/movies/delete/{movieId}")
         public ResponseEntity<MovieDTO> removeMovie(@PathVariable int movieId) {
             try {
                 MovieDTO removedMovieDTO = modelMapper.map(moviesService.removeMovie(movieId), MovieDTO.class);
                 logger.info("-------Movie With Movie id " + movieId + " Deleted---------");
                 return ResponseEntity.ok(removedMovieDTO);
             } catch (MovieNotFoundException e) {
                 
                 return ResponseEntity.status(404).build();
             }
         }
         
         @GetMapping("/byTheatre/{theatreId}")
         public ResponseEntity<List<MovieDTO>> viewMovieByTheatreId(@PathVariable int theatreId) {
             List<MovieDTO> movieDTOs = moviesService.viewMovieList(theatreId)
                     .stream()
                     .map(movie -> modelMapper.map(movie, MovieDTO.class))
                     .collect(Collectors.toList());

             logger.info("-------Movies With TheatreId " + theatreId + " Found---------");
             return ResponseEntity.ok(movieDTOs);
         }
         
         
         @GetMapping("/byDate")
         public ResponseEntity<List<MovieDTO>> viewMovieByLocalDate(
                 @RequestParam("movieDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
             List<MovieDTO> movieDTOs = moviesService.viewMovieList(date)
                     .stream()
                     .map(movie -> modelMapper.map(movie, MovieDTO.class))
                     .collect(Collectors.toList());

             logger.info("-------Movies With Date " + date + " Found---------");
             return ResponseEntity.ok(movieDTOs);
         }
     }
    

   


         
    



 
    




     





	         
