package com.interim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.interim.model.Logins;
import com.interim.util.HibernateUtil;

public class LoginsDao {
	
	Session session;

    public LoginsDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

    public void addLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Logins> getAllLogins() {
        List<Logins> logins = new ArrayList<Logins>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            logins = session.createQuery("from Logins").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return logins;
    }

    public Logins getLoginById(int loginid) {
        Logins login = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            login = (Logins) session.get(Logins.class, new Integer(loginid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return login;
    }
    
    
    public List<Logins> getLoginbyCriteria(Map<String, String> m) {
		List<Logins> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Logins.class);
            StringBuilder query = new StringBuilder("from Logins ");
    		
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
}