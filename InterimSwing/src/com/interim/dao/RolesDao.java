package com.interim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.interim.model.Roles;
import com.interim.util.HibernateUtil;

public class RolesDao {
	
	Session session;

    public RolesDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

    public void addRole(Roles role) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteRole(Roles role) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateRole(Roles role) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveRole(Roles role) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(role);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Roles> getAllRoles() {
        List<Roles> roles = new ArrayList<Roles>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            roles = session.createQuery("from Roles").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Roles getRoleById(int roleid) {
        Roles role = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            role = (Roles) session.get(Roles.class, new Integer(roleid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return role;
    }
    
    
    public List<Roles> getRolebyCriteria(Map<String, String> m) {
		List<Roles> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Roles.class);
            StringBuilder query = new StringBuilder("from Roles ");
    		
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