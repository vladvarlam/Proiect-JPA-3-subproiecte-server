/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.Client;
import db.Produs;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Vlad
 */
public class ClientDao {
    
    private EntityManager em;
    
    public ClientDao(EntityManager em) {
        this.em = em;
    }
    
    public void adaugaClient(Client c) {
        em.persist(c);
    
    
}

    public List<Client> getAllClients() {
        String sql = "SELECT c FROM Client c";
        TypedQuery<Client> q = em.createQuery(sql, Client.class);
        return q.getResultList();
    }
    
}
