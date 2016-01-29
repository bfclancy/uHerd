/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessEntities.Cattleowners;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author asus
 */
public class DBCattleOwners {
    
    public static void addToUserHerd(Cattleowners cattleOwner){
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(cattleOwner);
            trans.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            trans.rollback();
        }finally {
            em.close();
        }
    }
    
    public static List<String> getAllTagNumbersForUser(String herdNumber){
        List<String> tagNumbers = null;
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<String> q = em.createQuery("SELECT c.tagNumber FROM Cattleowners c WHERE c.herdNumber = ?1", String.class);
        q.setParameter(1, herdNumber);
        try{
            trans.begin();
            tagNumbers = q.getResultList();
            trans.commit();
        } catch(Exception e){
            System.out.println("here");
        }finally {
            em.close();
        }
        return tagNumbers;
    }
}
