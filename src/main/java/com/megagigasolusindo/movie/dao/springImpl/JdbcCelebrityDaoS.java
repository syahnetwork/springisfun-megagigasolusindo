package com.megagigasolusindo.movie.dao.springImpl;

import java.util.ArrayList;
import java.util.Set;

import com.megagigasolusindo.movie.dataproviders.CelebrityRole;
import com.megagigasolusindo.movie.model.Celebrity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.megagigasolusindo.movie.dao.CelebrityDao;
import com.megagigasolusindo.movie.dao.extractor.CelebrityRowMapper;

public class JdbcCelebrityDaoS extends JdbcDaoSupport implements CelebrityDao<Celebrity, CelebrityRole> {

    public ArrayList<Celebrity> findAllCelebritiesByRole(CelebrityRole role) {
        String sql = "SELECT * FROM celebrity WHERE " + role + " = 1 AND validationstatus = 1";
        ArrayList<Celebrity> celebrityList = (ArrayList<Celebrity>) getJdbcTemplate().query(sql, new CelebrityRowMapper());
        return celebrityList;
    }

    public ArrayList<Celebrity> findAllCelebritiesByStatus(int status) {
        String sql = "SELECT * FROM celebrity WHERE validationstatus = ?";
        ArrayList<Celebrity> celebrityList = (ArrayList<Celebrity>) getJdbcTemplate().query(sql,
                new Object[]{status}, new CelebrityRowMapper());
        return celebrityList;
    }

    public Celebrity findCelebrityById(int id) {
        String sql = "SELECT * FROM celebrity WHERE id = ?";
        Celebrity celebrity = (Celebrity) getJdbcTemplate().queryForObject(sql, new Object[]{id}, new CelebrityRowMapper());
        return celebrity;
    }

    public ArrayList<Celebrity> findCelebritiesByName(Set<String> names) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("namesParam", names);
        String sql = "SELECT * FROM celebrity WHERE name IN (:namesParam)";
        ArrayList<Celebrity> celebrities = (ArrayList<Celebrity>) namedParameterJdbcTemplate.query(sql, parameters,
                new CelebrityRowMapper());
        return celebrities;
    }

    public Celebrity findCelebrityByName(String name) {
        String sql = "SELECT * FROM celebrity WHERE name = ?";
        try {
            Celebrity celebrity = (Celebrity) getJdbcTemplate().queryForObject(sql, new Object[]{name}, new CelebrityRowMapper());
            return celebrity;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void persistCelebrity(Celebrity celebrity) {
        String sql = "INSERT INTO celebrity (name, director, actor, scriptwriter, validationstatus) VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, celebrity.getName(), celebrity.getIsDirector(), celebrity.getIsActor(),
                celebrity.getIsScriptwriter(), celebrity.getValidationStatus());
    }

    public void deleteCelebrity(int id) {
        String sql1 = "DELETE FROM celebrity WHERE id = ?";
        String sql2 = "DELETE FROM movie_leadactors WHERE actor_id = ?";
        String sql3 = "DELETE FROM movie_director WHERE director_id = ?";
        getJdbcTemplate().update(sql1, id);
        getJdbcTemplate().update(sql2, id);
        getJdbcTemplate().update(sql3, id);
    }

    public void updateCelebrity(Celebrity celebrity) {
        String sql = "UPDATE celebrity SET director = ?, actor = ?, scriptwriter = ?, validationstatus = ? WHERE id = ?";
        getJdbcTemplate().update(sql, celebrity.getIsDirector(), celebrity.getIsActor(),
                celebrity.getIsScriptwriter(), celebrity.getValidationStatus(), celebrity.getId());
    }

}
