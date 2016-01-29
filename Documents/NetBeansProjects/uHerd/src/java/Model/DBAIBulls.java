/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessEntities.Aibulls;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author asus
 */
public class DBAIBulls {
    
    public static List<Aibulls> getAllBulls(){
        List<Aibulls> aibulls = new ArrayList<>();
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<Aibulls> q = em.createQuery("SELECT a FROM Aibulls a", Aibulls.class);
        try{
            trans.begin();
            aibulls = q.getResultList();
            trans.commit();
        } catch(Exception e){
            System.out.println("here");
        }finally {
            em.close();
        }
        return aibulls;
    }
}
