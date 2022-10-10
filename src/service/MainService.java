/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ClientDao;
import dao.ProdusDao;
import db.Client;
import db.CodFidelizare;
import db.Eticheta;
import db.Produs;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import rmi.IMainService;

/**
 *
 * @author Vlad
 */
public class MainService extends UnicastRemoteObject implements IMainService{

    private EntityManagerFactory emf;

    public MainService() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("Java2ProiectPU");

    }
    //daca era privat constructorul de mai sus faceam cu singleton
//    private static final class SingletonHolder {
//        private static final ProdusService SINGLETON = new ProdusService();
//    }
//
//    public static ProdusService getInstance() {
//        return SingletonHolder.SINGLETON;
//    }
//

    
  /* public void adaugaClient() {
        EntityManager em = emf.createEntityManager();
        ClientDao clientDao = new ClientDao(em);
        
            Client c;
            c = new Client();

            
            
            //CodFidelizare cf=new CodFidelizare();
        Eticheta et1=new Eticheta();
        et1.setDepartament("ALIMENTAR");
        
        Eticheta et2=new Eticheta();
        et2.setDepartament("ELECTRICE");
        // se putea direct c.setCod("1234AD");si c.setJudet("AB");
//        cf.setJudet("AB");
//        cf.setCod("1234AD");
//        c.setCod(cf.getCod());
//        c.setJudet(cf.getJudet());
        c.setCod("123456AD");
        c.setJudet("AB");
        c.setNume("Marius");
        c.setTelefoane(new ArrayList<>());
        c.getTelefoane().add("0787999");
        c.getTelefoane().add("09855");
        
        c.setProduse(new ArrayList<>());
        Produs p1 = new Produs();
        
       // p1.setId(3);
        p1.setNume("PERE");
        p1.setPret(22);
        //s.modificaProdus(3,"PERE",22);
        p1.setClient(c);
        p1.setEticheta(et1);
        c.getProduse().add(p1);
        
        Produs p2 = new Produs();
        //p2.setId(4);
        p2.setNume("PRIZA");
        p2.setPret(55);
        //s.modificaProdus(4,"PRIZA",55);
        p2.setClient(c);
        p2.setEticheta(et2);
        c.getProduse().add(p2);
        
//        p1.setEticheta(et1);
//        p2.setEticheta(et2);
            
//            c.setJudet("Bistrita initial");
//            c.setCod("initial01");
//            c.setNume("nume initial");

try {
            em.getTransaction().begin();
            
            clientDao.adaugaClient(c);
            em.getTransaction().commit();
        } finally {
            em.close();
            
        }
    }
    
    */

   
    
    
    public void adaugaZeceProduse() {
        EntityManager em = emf.createEntityManager();
        ProdusDao produsDao = new ProdusDao(em);

        try {
            em.getTransaction().begin();
            for (int i = 1; i <= 10; i++) {
                Produs p = new Produs();
                p.setNume("PRODUS " + i);
                p.setPret(10);
                //p.setJudet("initial");
                Eticheta e=new Eticheta();
                e.setId(1);
                CodFidelizare cf=new CodFidelizare();
                cf.setJudet("initial");
                cf.setCod("nou");
                produsDao.adaugaProdus(p);
                em.flush();
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Produs> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            ProdusDao dao = new ProdusDao(em);
            return dao.getAllProducts();
        } finally {
            em.close();
            
          
        }
    }
    
    public List<Client> getAllClients() {
        EntityManager em = emf.createEntityManager();
        try {
            ClientDao dao = new ClientDao(em);
            return dao.getAllClients();
        } finally {
            em.close();
            
        }
    }

    public void stergeProdus(Produs p) {
        EntityManager em = emf.createEntityManager();
        ProdusDao dao = new ProdusDao(em);

        try {
            em.getTransaction().begin();
            //p = em.merge(p);
            p = dao.getProdus(p.getId());
            if (p != null) {
                dao.stergeProdus(p);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void modificaProdus(int id, String nume, double pret) {
        EntityManager em = emf.createEntityManager();
        ProdusDao dao = new ProdusDao(em);

        try {
            em.getTransaction().begin();
            Produs p = dao.getProdus(id);
            //em.detach(p);
            if (p != null) {
                p.setNume(nume);
                p.setPret(pret);
                //em.refresh(p);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
            
        }
    }
    @Override
    public void stergeProdusId(int Id) {
        EntityManager em = emf.createEntityManager();
        ProdusDao dao = new ProdusDao(em);

        try {
            em.getTransaction().begin();
            //p = em.merge(p);
           Produs p = dao.getProdus(Id);
            if (p != null) {
                dao.stergeProdus(p);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void adaugaClientPro(Client client) throws RemoteException {
        EntityManager em=emf.createEntityManager();
        ClientDao clientDao=new ClientDao(em);
        try{
        em.getTransaction().begin();
        clientDao.adaugaClient(client);
        
        em.getTransaction().commit();
        }finally{
        em.close();
        }
    }
   
}
