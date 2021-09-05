package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
/*@NamedQuery(name = "HQL_GET_ACTORS_BY_ACTORID_RANGE", query = "FROM Actor WHERE actorId>=:min  and actorId<=:max")
@NamedQuery(name = "HQL_DELETE_ACTORS_BY_ADDRS", query = "DELETE FROM Actor WHERE actorAddrs=:addrs")*/
@NamedQueries( value= {@NamedQuery(name ="HQL_GET_ACTORS_BY_ACTORID_RANGE",query = "FROM Actor WHERE actorId>=:min  and actorId<=:max"),
		                                     @NamedQuery(name = "HQL_DELETE_ACTORS_BY_ADDRS", query = "DELETE FROM Actor WHERE actorAddrs=:addrs")
                                      		 }		
	                          	)

public class Actor implements Serializable {
	@Id
	@GeneratedValue
	private Integer actorId;
	private String actorName;
	private String actorAddrs;
	private  Long mobileNo;
}
