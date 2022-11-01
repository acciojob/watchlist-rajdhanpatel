package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MovieService {
    //add movie by director name
    HashMap<String,Director> map = new HashMap<>();
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody(required = true)Director director){
        map.put(director.getName(),director);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getMovieByName(@PathVariable("name")String name){

        return new ResponseEntity<>(map.get(name),HttpStatus.ACCEPTED);
    }

    //all movie list by dir name : use pair class of movie and dir ie MovieRepository
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String>> getMoviesByDirectorName(@PathVariable("name")String dirName){
        ArrayList<String> listOfAllMovie = new ArrayList<>();
        //<movie, dir> : que is for pass dir name and tell movie name
        MovieRepository mr = new MovieRepository();
        HashMap<String,String> copyHereInMap = mr.getDataOfHashMap();
        for(String s :copyHereInMap.keySet() ){
            if(copyHereInMap.get(s)==dirName){
                listOfAllMovie.add(s);
            }

        }

        return new ResponseEntity<>(listOfAllMovie,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("String")String dirName){
        ArrayList<String> listOfAllMovie = new ArrayList<>();
        //<movie, dir> : que is for pass dir name and tell movie name
        MovieRepository mr = new MovieRepository();
        HashMap<String,String> copyHereInMap = mr.getDataOfHashMap();
        for(String s :copyHereInMap.keySet() ){
            if(copyHereInMap.get(s)==dirName){
                copyHereInMap.remove(copyHereInMap.get(s));
            }

        }

        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        ArrayList<String> listOfAllMovie = new ArrayList<>();
        //<movie, dir> : que is for pass dir name and tell movie name
        MovieRepository mr = new MovieRepository();
        HashMap<String,String> copyHereInMap = mr.getDataOfHashMap();
        copyHereInMap.clear();

        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }



}
