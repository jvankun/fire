/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;



import entity.Order;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author Johnny
 */
public class OrderFacade {
    EntityManagerFactory emf;

    public OrderFacade(EntityManagerFactory emf) {
            this.emf = emf;
    }

    
    
  public Order createOrder(Order o){
      EntityManager em = emf.createEntityManager();
      try{
          em.getTransaction().begin();
          em.persist(o);
          em.getTransaction().commit();
          return o;
      }finally{
          em.close();
      }
              
  }
  public List<Order> getAllOrders(){
     throw new UnsupportedOperationException("FIX ME, but write the test first");
  }
  public Order getOrderById(int id){
       throw new UnsupportedOperationException("FIX ME twice, but write the test first");
  }
}
