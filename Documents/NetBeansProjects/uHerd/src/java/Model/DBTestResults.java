/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessEntities.Testresults;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author asus
 */
public class DBTestResults {
    
    public static void addTestResult(Testresults testResult){
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(testResult);
            trans.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            trans.rollback();
        }finally {
            em.close();
        }
    }
}
