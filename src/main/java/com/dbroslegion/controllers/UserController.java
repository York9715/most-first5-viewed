package com.dbroslegion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbroslegion.models.*;
import com.dbroslegion.service.JpaUseHistoryRepository;

@RestController
public class UserController {

  @Autowired
  private UserDao userDao;

  @Autowired
  private ProductDao productDao;

  @Autowired
  private UseHistoryDao useHistoryDao;
  
  @Autowired
  private JpaUseHistoryRepository jpaUseHistoryRepository;
  
  /**
   * Return all UseHistory.
   * 
   * @param 
   * @return the List<Product> or null.
   */
  @RequestMapping("/listusehistory")
  public List<UseHistory> getUseHistories() {
    try {
      Iterable<UseHistory> users = useHistoryDao.findAll();
      return (List<UseHistory>) users;
    }
    catch (Exception ex) {
    	System.out.println(ex.getMessage());
    }
    return  null;
  }  
  
  /**
   * Return all UseHistory.
   * 
   * @param 
   * @return the List<Product> or null.
   */
  @RequestMapping("/listproducts")
  public List<Product> getProducts() {
    try {
      Iterable<Product> users = productDao.findAll();
      return (List<Product>) users;
    }
    catch (Exception ex) {
    	System.out.println(ex.getMessage());
    }
    return  null;
  }  
 
  
  /**
   * Return the mosted viewed.
   * 
   * @param e
   * @return the List<Product> or null.
   */
  @RequestMapping("/mostviewed")
  public List<Product> getMostviewed() {
    try {
      List<Product> mostviewed = jpaUseHistoryRepository.findMostViewed5th();
      return mostviewed;
    }
    catch (Exception ex) {
    	System.out.println(ex.getMessage());
    }
    return  null;
  } 
  
  
}
