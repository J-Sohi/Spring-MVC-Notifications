package com.fdmgroup.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.fdmgroup.model.User;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SpringMVCNotificationExample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		User u1 = new User("jdoe", "1234", "John", "Doe");
		User u2 = new User("asmith", "1234", "Alex", "Smith");
		User u3 = new User("dbowie", "1234", "David", "Bowie");
		
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		
		tr.commit();
		
		System.out.println("Objects stored.");
		
		em.close();
		emf.close();
	}
}
