package com.megagigasolusindo.movie.dao;

import com.megagigasolusindo.movie.dataproviders.CelebrityRole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.megagigasolusindo.movie.dao.hibernateImpl.JdbcCelebrityDaoH;
import com.megagigasolusindo.movie.dao.hibernateImpl.JdbcMovieDaoH;
import com.megagigasolusindo.movie.dao.hibernateImpl.JdbcReviewDaoH;
import com.megagigasolusindo.movie.dao.hibernateImpl.JdbcUserDaoH;
import com.megagigasolusindo.movie.dao.hibernateImpl.JdbcUserMovieDaoH;
import com.megagigasolusindo.movie.dao.hibernateImpl.JdbcUserRatingDaoH;
import com.megagigasolusindo.movie.model.Celebrity;
import com.megagigasolusindo.movie.model.Movie;
import com.megagigasolusindo.movie.model.MovieRejected;
import com.megagigasolusindo.movie.model.Review;
import com.megagigasolusindo.movie.model.User;

public class DaoFactory {

    private enum DaoType {
        HIBERNATE, JDBCTEMPLATE
    }

    private DaoType chooseDao = DaoType.JDBCTEMPLATE;
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");

    @SuppressWarnings({"unchecked", "rawtypes"})
    public MovieDao<Movie, MovieRejected> getMovieDao() {
        MovieDao<Movie, MovieRejected> jdbcMovieObject = null;
        if (chooseDao == DaoType.HIBERNATE) {
            jdbcMovieObject = new JdbcMovieDaoH();
        }
        if (chooseDao == DaoType.JDBCTEMPLATE) {
            jdbcMovieObject = (MovieDao) context.getBean("movieDao");
        }
        return jdbcMovieObject;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public UserDao<User> getUserDao() {
        UserDao<User> jdbcUserObject = null;
        if (chooseDao == DaoType.HIBERNATE) {
            jdbcUserObject = new JdbcUserDaoH();
        }
        if (chooseDao == DaoType.JDBCTEMPLATE) {
            jdbcUserObject = (UserDao) context.getBean("userDao");
        }
        return jdbcUserObject;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public UserMovieDao<User, Movie> getUserMovieDao() {
        UserMovieDao<User, Movie> jdbcUserMovieLink = null;
        if (chooseDao == DaoType.HIBERNATE) {
            jdbcUserMovieLink = new JdbcUserMovieDaoH();
        }
        if (chooseDao == DaoType.JDBCTEMPLATE) {
            jdbcUserMovieLink = (UserMovieDao) context.getBean("userMovieDao");
        }
        return jdbcUserMovieLink;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ReviewDao<Review, Movie, User> getReviewDao() {
        ReviewDao<Review, Movie, User> jdbcReviewObject = null;
        if (chooseDao == DaoType.HIBERNATE) {
            jdbcReviewObject = new JdbcReviewDaoH();
        }
        if (chooseDao == DaoType.JDBCTEMPLATE) {
            jdbcReviewObject = (ReviewDao) context.getBean("reviewDao");
        }
        return jdbcReviewObject;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public UserRatingDao<Movie, User> getUserRatingDao() {
        UserRatingDao<Movie, User> jdbcUserRatingObject = null;
        if (chooseDao == DaoType.HIBERNATE) {
            jdbcUserRatingObject = new JdbcUserRatingDaoH();
        }
        if (chooseDao == DaoType.JDBCTEMPLATE) {
            jdbcUserRatingObject = (UserRatingDao) context.getBean("userRatingDao");
        }
        return jdbcUserRatingObject;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public CelebrityDao<Celebrity, CelebrityRole> getCelebrityDao() {
        CelebrityDao<Celebrity, CelebrityRole> jdbcCelebrityObject = null;
        if (chooseDao == DaoType.HIBERNATE) {
            jdbcCelebrityObject = new JdbcCelebrityDaoH();
        }
        if (chooseDao == DaoType.JDBCTEMPLATE) {
            jdbcCelebrityObject = (CelebrityDao) context.getBean("celebrityDao");
        }
        return jdbcCelebrityObject;
    }

}
