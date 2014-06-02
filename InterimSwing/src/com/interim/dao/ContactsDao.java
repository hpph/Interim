package com.interim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.interim.model.Annonces;
import com.interim.model.Contacts;
import com.interim.util.HibernateUtil;

public class ContactsDao {
	
	Session session;

    public ContactsDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

    public void addContact(Contacts contact) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteContact(Contacts contact) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(contact);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateContact(Contacts contact) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(contact);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveContact(Contacts contact) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(contact);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Annonces> getAllAnnonces() {
        List<Annonces> annonces = new ArrayList<Annonces>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            annonces = session.createQuery("from Annonces").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return annonces;
    }

    public Annonces getContactById(int annonceid) {
        Annonces annonce = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            annonce = (Annonces) session.get(Annonces.class, new Integer(annonceid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return annonce;
    }
    
    
    public List<Contacts> getContactbyCriteria(Map<String, String> m) {
		List<Contacts> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Contacts.class);
            StringBuilder query = new StringBuilder("from Contacts ");
    		
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
    
    public ArrayList<String> getAllStringContacts() {
    	ArrayList<String> contacts = new ArrayList<String>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            contacts = (ArrayList<String>) session.createQuery("select contacts.entreprise from Contacts contacts").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}