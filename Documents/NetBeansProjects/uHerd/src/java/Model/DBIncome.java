/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessEntities.Income;
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
public class DBIncome {
    
    public static void addNewIncome(Income income){
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(income);
            trans.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            trans.rollback();
        }finally {
            em.close();
        }
    }
    
    public static List<Income> getAllIncomesForUser(String herdNumber){
        List<Income> incomes = new ArrayList<>();
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<Income> q = em.createQuery("SELECT i FROM Income i WHERE i.herdNumber = ?1", Income.class);
        q.setParameter(1, herdNumber);
        try{
            trans.begin();
            incomes = q.getResultList();
            trans.commit();
        } catch(Exception e){
            System.out.println("here");
        }finally {
            em.close();
        }
        return incomes;
    }
    
    public static double getTotalincomeForUser(String herdNumber){
        double totalIncome = 0;
        EntityManager em = DBUtils.getEMF().createEntityManager();
        TypedQuery<Double> q = em.createQuery("SELECT SUM (i.incomeAmount) FROM Income i WHERE i.herdNumber = ?1", Double.class);
        q.setParameter(1, herdNumber);
        try{
            totalIncome = (double) q.getSingleResult();
        } catch(Exception e){
            System.out.println(e);
        }
        return totalIncome;
    }
}
