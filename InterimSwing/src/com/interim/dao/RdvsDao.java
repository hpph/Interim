package com.interim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.interim.model.Rdvs;
import com.interim.model.Users;
import com.interim.util.HibernateUtil;

public class RdvsDao {
	
	Session session;

    public RdvsDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

    public void addRdv(Rdvs rdv) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(rdv);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteRdv(Rdvs rdv) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(rdv);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateRdv(Rdvs rdv) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(rdv);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveRdv(Rdvs rdv) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(rdv);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Rdvs> getAllRdvs() {
        List<Rdvs> rdvs = new ArrayList<Rdvs>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            rdvs = session.createQuery("from Rdvs").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return rdvs;
    }

    public Rdvs getRdvById(int rdvid) {
        Rdvs rdv = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            rdv = (Rdvs) session.get(Rdvs.class, new Integer(rdvid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return rdv;
    }
    
    public List<Map<String, String>> getRdvsbyMonth(String annee,int idUser) {
		List<Map<String, String>> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select COUNT(*) AS nombre, MONTH(`date`) AS moisNumeros from rdvs where YEAR(rdvs.date) = :annee and rdvs.id_user = :idUser GROUP BY moisNumeros");
            query.setParameter("annee", annee);
            query.setParameter("idUser", idUser);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            list = query.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<String> getRdvsDirs(int annee) {
		List<String> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Query query = session.createQuery("select rdvs.dir from Rdvs rdvs WHERE YEAR(rdvs.date) = :annee");
            query.setParameter("annee", annee);
            list = query.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public List<Rdvs> getRdvbyCriteria(Map<String, String> m) {
		List<Rdvs> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Rdvs.class);
            StringBuilder query = new StringBuilder("from Rdvs ");
    		
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