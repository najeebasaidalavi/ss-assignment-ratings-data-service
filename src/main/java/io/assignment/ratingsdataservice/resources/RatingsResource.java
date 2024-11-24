package io.assignment.ratingsdataservice.resources;

import io.assignment.ratingsdataservice.model.Rating;
import io.assignment.ratingsdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping("/movies/{movieId}")
    public List<Rating> getMovieRating(@PathVariable("movieId") int movieId) {
        List<Rating> ratings = ratingRepository.findByMovieId(movieId);
        return ratings;
    }

    @RequestMapping("/user/{userId}")
    public  List<Rating> getUserRatings(@PathVariable("userId") int userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
       // userRating.initData(userId);
        return ratings;

    }

    @PostMapping("/rating")
    public Rating setRatings(@RequestBody Rating rating) {
        rating = ratingRepository.saveAndFlush(rating);
        // userRating.initData(userId);
        return rating;
    }

}
