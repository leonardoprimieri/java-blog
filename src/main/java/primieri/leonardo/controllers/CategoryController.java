package primieri.leonardo.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import primieri.leonardo.model.Category;


public class CategoryController {

private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("trabg22");
	
	public static List<Category> getCategories() {

		List<Category> categories = null;
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			TypedQuery<Category> tq = em.createQuery("SELECT c FROM cat c", Category.class);
			categories = tq.getResultList();
			
			transaction.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			em.close();
		}
		return categories;
	
	}
	
}
