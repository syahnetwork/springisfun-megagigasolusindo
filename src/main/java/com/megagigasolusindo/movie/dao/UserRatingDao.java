package com.megagigasolusindo.movie.dao;

import com.megagigasolusindo.movie.model.UserRating;

public interface UserRatingDao<M, U> {
    public void submitVote(M movie, U user, int rating);

    public UserRating getUserRating(M movie, U user);
}
