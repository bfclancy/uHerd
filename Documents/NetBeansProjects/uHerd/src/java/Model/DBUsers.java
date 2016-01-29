/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessEntities.Counties;
import BusinessEntities.Userrole;
import BusinessEntities.Users;
import IBusinessEntities.IUserrole;
import IBusinessEntities.IUsers;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author asus
 */
public class DBUsers {
    
    public static Users getUserByUsername(String username){
        Users user = null;
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        TypedQuery<Users> q = em.createQuery("SELECT u FROM Users u WHERE u.userName = ?1", Users.class);
        q.setParameter(1, username);
        try{
            trans.begin();
            user = q.getSingleResult();
            trans.commit();
        } catch(Exception e){
            System.out.println("here");
        }finally {
            em.close();
        }
        return user;
    }
    
    public static void addNewUser(IUsers user){
        EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(user);
            trans.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            trans.rollback();
        }finally {
            em.close();
        }
    }
    
    public static void addNewUserRole(IUserrole ur){
       EntityManager em = DBUtils.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(ur);
            trans.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            trans.rollback();
        }finally {
            em.close();
        } 
    }
}
