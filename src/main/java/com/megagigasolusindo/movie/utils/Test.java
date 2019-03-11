package com.megagigasolusindo.movie.utils;

import com.megagigasolusindo.movie.dao.UserDao;

import com.megagigasolusindo.movie.dao.CelebrityDao;
import com.megagigasolusindo.movie.dao.DaoFactory;
import com.megagigasolusindo.movie.dao.MovieDao;
import com.megagigasolusindo.movie.dao.UserRatingDao;
import com.megagigasolusindo.movie.dataproviders.CelebrityRole;
import com.megagigasolusindo.movie.model.Celebrity;
import com.megagigasolusindo.movie.model.Movie;
import com.megagigasolusindo.movie.model.MovieRejected;
import com.megagigasolusindo.movie.model.User;

public class Test {

    static DaoFactory daoFactory = new DaoFactory();
    static MovieDao<Movie, MovieRejected> jdbcMovieObject = daoFactory.getMovieDao();
    static UserDao<User> jdbcUserObject = daoFactory.getUserDao();
    static UserRatingDao<Movie, User> jdbcUserRatingObject = daoFactory.getUserRatingDao();
    static CelebrityDao<Celebrity, CelebrityRole> jdbcCelebrityObject = daoFactory.getCelebrityDao();

    public static void main(String[] args) {
        Movie movie = jdbcMovieObject.findMovieById(1);
        System.out.println(movie);
    }

}

//test
