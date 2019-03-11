package com.megagigasolusindo.movie.dao.hibernateImpl;

import java.util.ArrayList;
import java.util.Set;

import com.megagigasolusindo.movie.dataproviders.CelebrityRole;
import com.megagigasolusindo.movie.model.Celebrity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.megagigasolusindo.movie.dao.CelebrityDao;
import com.megagigasolusindo.movie.dao.ConnectionHandler;

public class JdbcCelebrityDaoH implements CelebrityDao<Celebrity, CelebrityRole> {

    private ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

    @SuppressWarnings("unchecked")
    public ArrayList<Celebrity> findAllCelebritiesByRole(CelebrityRole role) {
        String sql = "SELECT * FROM celebrity WHERE " + role + " = 1 AND validationstatus = 1";
        Session session = connectionHandler.openCurrentSession();
        ArrayList<Celebrity> celebrityList = (ArrayList<Celebrity>) session.createSQLQuery(sql).addEntity(Celebrity.class).list();
        connectionHandler.closeCurrentSession();
        return celebrityList;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Celebrity> findAllCelebritiesByStatus(int status) {
        connectionHandler.openCurrentSession();
        Criteria criteria = connectionHandler.getCurrentSession().createCriteria(Celebrity.class);
        ArrayList<Celebrity> celebrities = (ArrayList<Celebrity>) criteria.add(Restrictions.eq("validationStatus", status)).list();
        connectionHandler.closeCurrentSession();
        return celebrities;
    }

    public Celebrity findCelebrityById(int id) {
        connectionHandler.openCurrentSession();
        Celebrity celebrity = (Celebrity) connectionHandler.getCurrentSession().get(Celebrity.class, id);
        connectionHandler.closeCurrentSession();
        return celebrity;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Celebrity> findCelebritiesByName(Set<String> names) {
        connectionHandler.openCurrentSession();
        Criteria criteria = connectionHandler.getCurrentSession().createCriteria(Celebrity.class);
        ArrayList<Celebrity> celebrities = (ArrayList<Celebrity>) criteria.add(Restrictions.in("name", names)).list();
        connectionHandler.closeCurrentSession();
        return celebrities;
    }

    public void persistCelebrity(Celebrity celebrity) {
        connectionHandler.openCurrentSessionwithTransaction();
        connectionHandler.getCurrentSession().save(celebrity);
        connectionHandler.closeCurrentSessionwithTransaction();
    }

    public void deleteCelebrity(int id) {
        Session session = connectionHandler.openCurrentSessionwithTransaction();
        String sql1 = String.format("DELETE FROM celebrity WHERE id = %s", id);
        String sql2 = String.format("DELETE FROM movie_leadactors WHERE actor_id = %s", id);
        String sql3 = String.format("DELETE FROM movie_director WHERE director_id = %s", id);
        session.createSQLQuery(sql1).executeUpdate();
        session.createSQLQuery(sql2).executeUpdate();
        session.createSQLQuery(sql3).executeUpdate();
        connectionHandler.closeCurrentSessionwithTransaction();
    }

    public Celebrity findCelebrityByName(String name) {
        connectionHandler.openCurrentSession();
        Criteria criteria = connectionHandler.getCurrentSession().createCriteria(Celebrity.class);
        Celebrity celebrity = null;
        if (criteria.add(Restrictions.eq("name", name)).list().size() != 0) {
            celebrity = (Celebrity) criteria.add(Restrictions.eq("name", name)).list().get(0);
        }
        connectionHandler.closeCurrentSession();
        return celebrity;
    }

    public void updateCelebrity(Celebrity celebrity) {
        connectionHandler.openCurrentSessionwithTransaction();
        connectionHandler.getCurrentSession().update(celebrity);
        connectionHandler.closeCurrentSessionwithTransaction();
    }

}
