/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author asus
 */
public class DBUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("uHerdPU");
    
    public static EntityManagerFactory getEMF() {
        return emf;
    }
}
