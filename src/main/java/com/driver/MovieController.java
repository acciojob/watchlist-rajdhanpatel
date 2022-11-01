package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MovieController {
    //add movie by movie name
    HashMap<String,Movie> map = new HashMap<>();
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody(required = true)Movie movie){
        map.put(movie.getName(),movie);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){

        return new ResponseEntity<>(map.get(name),HttpStatus.ACCEPTED);
    }

}
