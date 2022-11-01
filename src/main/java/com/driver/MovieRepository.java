package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


//add movie by movie-dir-pairWise


@RestController
public class MovieRepository {
    private HashMap<String,String> mapofPair = new HashMap<>();
    public HashMap<String,String> getDataOfHashMap(){
        return mapofPair;
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("String")String movieName,@RequestParam("String")String dirName) {
        mapofPair.put(movieName, dirName);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
}
