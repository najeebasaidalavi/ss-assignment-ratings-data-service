package io.assignment.ratingsdataservice.repository;

import io.assignment.ratingsdataservice.model.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long>, JpaSpecificationExecutor<Rating> {

    @Query("Select r from Rating r where r.userId = :userId")
    List<Rating> findByUserId(int userId);

    @Query("Select r from Rating r where r.movieId = :movieId")
    List<Rating> findByMovieId(int movieId);
}
