package primieri.leonardo.test;



import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Test;

import primieri.leonardo.model.Post;
import primieri.leonardo.model.User;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TestConnectionJPA {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("trabg22");
	
	//@Test
	public void createPost() {
		EntityManager em  = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		
		try {
			

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

			
	
			transaction = em.getTransaction();
			transaction.begin();
			
			Post post = new Post();
			
			
			post.setTitle("Test post from JPA");
			post.setDescription("Test description from JPA");
			post.setDate(dtf.format(now));
			post.setImageURL("Test image from JPA");
			
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
	
	//@Test
	public void getPosts() {
		List<Post> posts = null;
		
		EntityManager em  = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		posts = em.createQuery("SELECT p FROM posts p", Post.class).getResultList();
		
		for(Post p:posts) {
			System.out.println(p.getTitle());
		}
		assertNotNull(posts);
		
		
	}
	
	@Test
	public void createUser() {
		EntityManager em  = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		
		try {
			

			transaction = em.getTransaction();
			transaction.begin();
			
			User user = new User();
			
			
			user.setEmail("emailFromJPA");
			user.setPassword("passFromJPA");
			
			em.persist(user);
			
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
