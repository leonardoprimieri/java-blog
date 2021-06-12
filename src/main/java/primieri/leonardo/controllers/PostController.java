package primieri.leonardo.controllers;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import primieri.leonardo.model.Post;

public class PostController {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("trabg22");
	
	public static List<Post> getPosts() {

		List<Post> posts = null;
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		
		try {
			transaction = em.getTransaction();
			transaction.begin();
			TypedQuery<Post> tq = em.createQuery("SELECT p FROM posts p", Post.class);
			posts = tq.getResultList();
			
			transaction.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			em.close();
		}
		return posts;
	
	}
	
	
	public static void createPost(String title, String description, String imageURL) {
		EntityManager em  = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		
		try {
			

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

			
	
			transaction = em.getTransaction();
			transaction.begin();
			
			Post post = new Post();
			
			
			post.setTitle(title);
			post.setDescription(description);
			post.setDate(dtf.format(now));
			post.setImageURL(imageURL);
			
			em.persist(post);
			
			transaction.commit(); 
			
			
			
		} catch(Exception e) {
				
			if(transaction != null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		} finally {
			em.close();
		}
	
	}
	

}
