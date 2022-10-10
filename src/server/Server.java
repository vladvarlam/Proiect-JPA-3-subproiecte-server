/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import db.Client;
import db.CodFidelizare;
import db.Eticheta;
import db.Produs;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import service.MainService;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
//si pun ceva in test branch
public class Server {

    /**
     * @param args the command line arguments
     */
   // public static  EntityManagerFactory emf;
    public static void main(String[] args) {
       // emf = Persistence.createEntityManagerFactory("java2c2e5trisPU");
       try{
       Registry registry=LocateRegistry.createRegistry(4444);
      // MainService s=new MainService();
       registry.rebind("produsService",new MainService());
//       s.adaugaClient();
//        
//        
//        
//        
//        s.getAll().forEach(System.out::println);
//        s.getAllClients().forEach(System.out::println);
//        s.modificaProdus(1, "branza", 223);//prin ecran
//        System.out.println(s.getAll().get(1));
//        System.out.println(s.getAll().get(0));
//        System.out.println(s.getAllClients().get(0));
//        System.out.println(s.getAllClients().get(0).getNume());
//        System.out.println(s.getAllClients().get(0).getTelefoane());
       // s.stergeProdusId(1);//prin ecran.TODO
//        s.getAll().forEach(System.out::println);
//        MainFrame f=new MainFrame();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
       }catch(Exception e){
       e.printStackTrace();
       }
        
        //am comentat aici
  /*      s.adaugaZeceProduse();
        Produs p = new Produs();
        p.setId(6);
        s.stergeProdus( p);
        s.modificaProdus(8, "ALT PRODUS", 50);
        
      */  
        
        // TODO code application logic here
        //alternativa singleton
        //        ProdusService.getInstance().stergeProdus(p);
//        ProdusService.getInstance().modificaProdus(8, "ALT PRODUS", 100
        // ProdusService.getInstance().getAll().forEach(System.out::println);
        
       // Client c=new Client();
//        CodFidelizare cf=new CodFidelizare();
//        Eticheta et1=new Eticheta();
//        et1.setDepartament("ALIMENTAR");
//        
//        Eticheta et2=new Eticheta();
//        et2.setDepartament("ELECTRICE");
//        
//        cf.setJudet("AB");
//        cf.setCod("1234AD");
//        c.setCod(cf.getCod());
//        c.setJudet(cf.getJudet());
//        c.setNume("Marius");
//        c.setTelefoane(new ArrayList<>());
//        c.getTelefoane().add("0787999");
//        c.getTelefoane().add("09855");
//        
//        c.setProduse(new ArrayList<>());
//        Produs p1 = new Produs();
//        p1.setId(3);
//       s.modificaProdus(3,"PERE",22);
//        p1.setClient(c);
//        p1.setEticheta(et1);
//        c.getProduse().add(p1);
//        
//        Produs p2 = new Produs();
//        p2.setId(4);
//       s.modificaProdus(4,"PRIZA",55);
//        p2.setClient(c);
//        p2.setEticheta(et2);
//        c.getProduse().add(p2);
//        
//        p1.setEticheta(et1);
//        p2.setEticheta(et2);
        
        
        
        
    }
    
}
