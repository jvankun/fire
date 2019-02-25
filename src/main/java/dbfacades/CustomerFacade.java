/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Johnny
 */
public class CustomerFacade {
     EntityManagerFactory emf;

  public CustomerFacade(EntityManagerFactory emf) {
    this.emf = emf;
  }
  
  public Customer createCustomer(Customer c){
     EntityManager em = emf.createEntityManager();
      try{
          em.getTransaction().begin();
          em.persist(c);
          em.getTransaction().commit();
          return c;
      }finally{
          em.close();
      }     
    }
  public Customer findCustomerById(int id){
      EntityManager em = emf.createEntityManager();
      try{
          return (Customer) em.createQuery("select c from Customer c where c.id =:id").setParameter("id", id).getSingleResult();
      }finally{
          em.close();
      }
      //throw new UnsupportedOperationException("FIX ME, but write the test first");
  }
  
  public List<Customer> getAllCustomers(){
      EntityManager em = emf.createEntityManager();
      try{
          Query q = em.createNativeQuery("select c.id, c.name, c.email From Customer c",Customer.class);
          List<Customer> list = q.getResultList();
          return list;
      }finally{
          em.close();
      }
      
  }
}
