package com.masai.emutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("product");
	}
	
	public static EntityManager provideEntityManage() {
		
		return emf.createEntityManager();
	}
}
