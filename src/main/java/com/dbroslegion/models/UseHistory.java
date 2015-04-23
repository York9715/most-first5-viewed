package com.dbroslegion.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * An entity UseHistory composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author ychen
 */
@Entity
@Table(name = "usehistory")
public class UseHistory {
 
  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  private String prodid;

  private String userid;
  
  private String updated;

  protected UseHistory() { }

  public UseHistory(String prodid, String userid, String updated) {
    this.prodid = prodid;
    this.userid = userid;
    this.updated = updated;
  }
	
	public String getProdid() {
		return prodid;
	}
	
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getUpdated() {
		return updated;
	}
	
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	  @Override
	  public String toString() {
		  return "id=" + Long.toString(id)  + ";prodid=" + this.prodid + ";userid=" + userid + ";updated=" + this.updated;
	  }
	  		
}  
  
  