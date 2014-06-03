package com.interim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.interim.model.Adresses;
import com.interim.util.HibernateUtil;

public class AdressesDao {
	
	Session session;

    public AdressesDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	

    public void addAdresse(Adresses adresse) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(adresse);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAdresse(Adresses adresse) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(adresse);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateAdresse(Adresses adresse) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(adresse);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveAdresse(Adresses adresse) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(adresse);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Adresses> getAllAdresses() {
        List<Adresses> adresses = new ArrayList<Adresses>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            adresses = session.createQuery("from Adresses").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return adresses;
    }

    public Adresses getAdresseById(int adresseid) {
        Adresses adresse = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            adresse = (Adresses) session.get(Adresses.class, new Integer(adresseid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return adresse;
    }
    
    
    public List<Adresses> getAdressebyCriteria(Map<String, String> m) {
		List<Adresses> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Adresses.class);
            StringBuilder query = new StringBuilder("from Adresses ");
    		
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