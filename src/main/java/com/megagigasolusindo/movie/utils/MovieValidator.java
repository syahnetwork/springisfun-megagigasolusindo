package com.megagigasolusindo.movie.utils;

import java.util.Calendar;

import com.megagigasolusindo.movie.model.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MovieValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Movie.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "required.year");

        Movie movie = (Movie) target;

        if (!Integer.toString(movie.getYear()).matches("^(19|20)\\d{2}$") || (movie.getYear() > Calendar.getInstance().get(Calendar.YEAR))) {
            errors.rejectValue("year", "formaterror.year");
        }

    }

}
