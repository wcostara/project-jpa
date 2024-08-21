package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Jonh Lenon Costa", "john@gmail.com");
		Pessoa p3 = new Pessoa(null, "Elfrates Solimoes", "elfrates@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println(p);
		
		System.out.println("PRONTO !!!");
		emf.close();
		em.close();
	}
}
