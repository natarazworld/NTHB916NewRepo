package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "GET_ALL_ACTORS_BY_ADDRS",
                                       query = "SELECT ACTORID,ACTORNAME,ACTORADDRS,MOBILENO FROM ACTOR WHERE ACTORADDRS=? ",
                                       resultClass = Actor.class)

@NamedNativeQuery(name = "GET_ACTORS_DATA_BY_ACTORID_RANAGE",
                                query = "SELECT ACTORID,ACTORNAME,ACTORADDRS  FROM ACTOR WHERE ACTORID >=?  AND ACTORID<=? ")

@NamedNativeQuery(name = "CHANGE_ACTOR_ADDRS_BY_NAME",
              query = "UPDATE ACTOR SET  ACTORADDRS=:newAddrs WHERE ACTORNAME=:name")

public class Actor implements Serializable {
	@Id
	private Integer actorId;
	private String actorName;
	private String actorAddrs;
	private  Long mobileNo;
}
