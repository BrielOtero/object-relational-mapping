package com.linkedin.learning.otrareunionmas.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public static EntityManager gEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OtraReunionMas");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	public static void main(String[] args) {
		EntityManager manager = EntityManagerUtil.gEntityManager();
		System.out.println("EntityManager class ==> "+ manager.getClass().getCanonicalName());
	}
	
}
