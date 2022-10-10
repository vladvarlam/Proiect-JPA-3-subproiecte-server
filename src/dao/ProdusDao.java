/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.Produs;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Vlad
 */
public class ProdusDao {
    
    private EntityManager em;
    
    public ProdusDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaProdus(Produs p) {
        em.persist(p);
    
    
}
    public List<Produs> getAllProducts() {
        String sql = "SELECT p FROM Produs p";// cu nativ era "SELECT * FROM PRODUS"
        TypedQuery<Produs> q = em.createQuery(sql, Produs.class);
        return q.getResultList();
    }
    
    public Produs getProdus(int id) {
        return em.find(Produs.class, id);
    }
    
    public void stergeProdus(Produs p) {
        em.remove(p);
    }
}
