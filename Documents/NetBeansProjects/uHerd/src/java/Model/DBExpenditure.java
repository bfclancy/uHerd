/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessEntities.Expenditure;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author asus
 */
public class DBExpenditure {
    
    public static void addNewExpenditure(Expenditure expenditure){
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(expenditure);
            trans.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            trans.rollback();
        }finally {
            em.close();
        }
    }
    
    public static List<Expenditure> getAllExpendituresForUser(String herdNumber){
        List<Expenditure> expenditures = new ArrayList<>();
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<Expenditure> q = em.createQuery("SELECT e FROM Expenditure e WHERE e.herdNumber = ?1", Expenditure.class);
        q.setParameter(1, herdNumber);
        try{
            trans.begin();
            expenditures = q.getResultList();
            trans.commit();
        } catch(Exception e){
            System.out.println("here");
        }finally {
            em.close();
        }
        return expenditures;
    }
    
    public static double getTotalExpenditureForUser(String herdNumber){
        double totalExpenditure = 0;
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<Double> q = em.createQuery("SELECT SUM (e.expenditureAmount) FROM Expenditure e WHERE e.herdNumber = ?1", Double.class);
        q.setParameter(1, herdNumber);
        try{
            totalExpenditure = (double) q.getSingleResult();
        } catch(Exception e){
            System.out.println(e);
        }
        return totalExpenditure;
    }
}
