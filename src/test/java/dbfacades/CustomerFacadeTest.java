/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;

import dbfacades.CustomerFacade;
import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Johnny
 */
public class CustomerFacadeTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test", null);

  CustomerFacade facade = new CustomerFacade(emf);

  /**
   * Setup test data in the database to a known state BEFORE Each test
   */
  @Before
  public void setUp() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();
      //Delete all, since some future test cases might add/change data
      em.createQuery("delete from Customer").executeUpdate();
      //Add our test data
      Customer c1 = new Customer("Mette Hansen", "mh@yahoo.com");
      Customer c2 = new Customer("Lone Jensen", "lj@yahoo.com");
      em.persist(c1);
      em.persist(c2);
      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }
  
/*@Test
public void testFindCustomer(){
    List<Customer> allCustomers = facade.
}*/
  @Test
  public void testGetAllCustomers(){
      List<Customer> allCustomers = facade.getAllCustomers();
      Assert.assertEquals(2,allCustomers.size()); 
      String name = allCustomers.get(1).getName();
      String mail = allCustomers.get(1).getEmail();
      Assert.assertEquals("Mette Hansen",name);
      Assert.assertEquals("mh@yahoo.com", mail);
  }
  @Test
  public void testFindCustomerById(){
      List<Customer> allCustomers = facade.getAllCustomers();
      int id = allCustomers.get(1).getId();
      String name = allCustomers.get(1).getName();
      String mail = allCustomers.get(1).getEmail();
      Customer c = facade.findCustomerById(id);
      Assert.assertEquals(c.getName(),name);
      Assert.assertEquals(c.getEmail(), mail);
      
      
  }
}
    

