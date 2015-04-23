package com.dbroslegion.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbroslegion.models.*;

@Repository
public class JpaUseHistoryRepository implements UseHistoryRepository {
	
	@Autowired
	private ProductDao productDao;
	  
	@PersistenceContext
	private EntityManager  entityManager;
	
	@Override
	public List<Product> findMostViewed5th(){
		String sql="";
		String prodID="";
		String type="";
		List<Product> mostViewed = new ArrayList<Product>();
		
		sql=sql + "SELECT MIN(usehistory.prodid) AS prodid, COUNT(usehistory.prodid) AS viewedNum, product.prodtype AS type ";
		sql=sql + " FROM product RIGHT JOIN usehistory ON product.prodid = usehistory.prodid";
		sql=sql + " GROUP BY product.prodtype ";
		sql=sql + " ORDER BY COUNT(usehistory.prodid) DESC";
		System.out.println(sql);
		
		//TypedQuery<Object[]> query = this.entityManager.createQuery(sql,Object[].class);
		Query query=this.entityManager.createNativeQuery(sql);
		List<Object[]> results = query.setMaxResults(5).getResultList();
		for (Object[] result : results) {
			prodID=(String)result[0];
			type=(String)result[2];
			Product p = productDao.findByProdidAllIgnoringCase(prodID);
			//Product p = productDao.findByProdId(prodID);
			mostViewed.add(p);
		} 
		
		return mostViewed;
	}
	
}
