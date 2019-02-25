/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;

import entity.Order;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Johnny
 */
public class OrderFacadeTest {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test", null);

    OrderFacade facade = new OrderFacade(emf);
  
 
  @Before
  public void setUp() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();
      //Delete all, since some future test cases might add/change data
      em.createQuery("delete from Order").executeUpdate();
      //Add our test data
      Order o1 = new  Order(10);
      Order o2 = new  Order(11);
      em.persist(o1);
      em.persist(o2);
      em.getTransaction().commit();
    } finally {
      em.close();
    }
}
  public void testGetAllOrders{
    
}
    
}
