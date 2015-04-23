package com.dbroslegion.models;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 * A DAO for the entity Product is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author ychen
 */
@Transactional
public interface ProductDao extends CrudRepository<Product, Long> {

	  /**
	   * Return the  Product having the passed id or null if no user is found.
	   * 
	   * @param prodid the user email.
	   */
	 //public Product findByProdId(String prodId);
	 public  Product findByProdidAllIgnoringCase(String prodid);

} 
