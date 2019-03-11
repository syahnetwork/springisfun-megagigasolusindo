package com.megagigasolusindo.movie.dao.springImpl;

import java.util.ArrayList;

import com.megagigasolusindo.movie.dao.UserDao;
import com.megagigasolusindo.movie.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcUserDaoS extends JdbcDaoSupport implements UserDao<User> {

    public void persistUser(User user) {
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        getJdbcTemplate().update(sql, user.getUsername(), user.getPassword());
    }

    public void deleteUser(User user) {
        String sql1 = "DELETE FROM user WHERE username = ?";
        getJdbcTemplate().update(sql1, user.getUsername());
        String sql2 = "DELETE FROM user_movie_link WHERE username = ?";
        getJdbcTemplate().update(sql2, user.getUsername());
        String sql3 = "UPDATE review SET author = '" + user.getUsername() + "_deleted' WHERE author = ?";
        getJdbcTemplate().update(sql3, user.getUsername());
        String sql4 = "UPDATE movie SET added_by = '" + user.getUsername() + "_deleted' WHERE added_by = ?";
        getJdbcTemplate().update(sql4, user.getUsername());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ArrayList<User> findAllUsers() {
        String sql = "SELECT * FROM user";
        ArrayList<User> userList = (ArrayList<User>) getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(User.class));
        return userList;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public User findUser(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        User user = (User) getJdbcTemplate().queryForObject(sql, new Object[]{username},
                new BeanPropertyRowMapper(User.class));
        return user;
    }

}
