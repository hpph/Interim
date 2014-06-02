package com.interim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.interim.model.Users;
import com.interim.util.HibernateUtil;

public class UsersDao {
	
	Session session;

    public UsersDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void addUser(Users user) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteUser(Users user) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUser(Users user) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveUser(Users user) {
        Transaction trns = null;
        
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Users where idUser is not null").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Users getUserById(int userid) {
        Users user = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            user = (Users) session.get(Users.class, new Integer(userid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }
    
    
    public List<Users> getUserbyCriteria(Map<String, String> m) {
		List<Users> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Users.class);
            StringBuilder query = new StringBuilder("from Users ");
    		
    		for (Map.Entry<String, String> entry : m.entrySet())
    		{
    			cr.add(Restrictions.eq(entry.getKey(), entry.getValue()));
    		}
    		list = cr.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Users> getUserbyLogin(String username, String password) {
		List<Users> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            list = session.createSQLQuery("select * from users,logins where users.id_login = logins.id_login and logins.username = :username and logins.password = :password and id_superviseur is not null")
            		.addEntity(Users.class)
            		.setParameter("username", username)
            		.setParameter("password", password)
            		.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Users> getUserbyLoginSuperviseur(String username, String password) {
		List<Users> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            list = session.createSQLQuery("select * from users,logins where users.id_login = logins.id_login and logins.username = :username and logins.password = :password and id_superviseur is null")
            		.addEntity(Users.class)
            		.setParameter("username", username)
            		.setParameter("password", password)
            		.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Users> getUserSuperviseur() {
		List<Users> list = null;
        Transaction trns = null;
        try {
        	trns = session.beginTransaction();
        	Query query = session.createSQLQuery(
            		"select * from users s where s.id_superviseur IS NULL")
            		.addEntity(Users.class);
            list = query.list();

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}