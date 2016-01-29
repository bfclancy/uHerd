/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author asus
 */
public class DBCounties {
    
    public static List<String> getAllCounties(){
        List<String> counties = null;
        EntityManager em = DBUtils.getEMF().createEntityManager();
        TypedQuery<String> q = em.createQuery("SELECT c FROM Counties c", String.class);
        try{
            counties = q.getResultList();
        } catch(Exception e){
            System.out.println("here");
        }
        return counties;
    }
    
}
