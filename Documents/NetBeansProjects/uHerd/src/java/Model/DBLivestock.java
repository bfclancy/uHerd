/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessEntities.Cattle;
import IBusinessEntities.ICattle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author asus
 */
public class DBLivestock {
    
    public static void registerNewAnimal(Cattle cattle){
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(cattle);
            trans.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public static Cattle getAnimalByTagNumber(String tagNumber){
        Cattle cattle = null;
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<Cattle> q = em.createQuery("SELECT c FROM Cattle c WHERE c.tagNumber = ?1", Cattle.class);
        q.setParameter(1, tagNumber);
        try{
            trans.begin();
            cattle = q.getSingleResult();
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
        }finally {
            em.close();
        }
        return cattle;
    }
    
    public static List<Cattle> getAllLivestock(){
        List<Cattle> cattle = null;
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<Cattle> q = em.createQuery("SELECT c FROM Cattle c", Cattle.class);
        try{
            trans.begin();
            cattle = q.getResultList();
            trans.commit();
        } catch(Exception e){
            System.out.println("here");
        }finally {
            em.close();
        }
        return cattle;
    }
}
