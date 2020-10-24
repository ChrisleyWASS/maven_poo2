package automovel;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("automovel");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			Marca m1     = new Marca(null, "Jeep");
			Modelo md1	 = new Modelo(null, "Renegade", 500, m1);
			Automovel a1 = new Automovel(null, 2019, 2020, "preto", 112390, 1000, md1);
			
			Marca m2     = new Marca(null, "Renaut");
			Modelo md2	 = new Modelo(null, "Kwid", 450, m2);
			Automovel a2 = new Automovel(null, 2018, 2019, "branco", 38690, 500, md2);
			
			Marca m3     = new Marca(null, "Nissan");
			Modelo md3	 = new Modelo(null, "Corolla", 400, m3);
			Automovel a3 = new Automovel(null, 2019, 2020, "prata", 110190, 950, md3);
			
			
			em.persist(m1);
			em.persist(md1);
			em.persist(a1);
			
			em.persist(m2);
			em.persist(md2);
			em.persist(a2);
			
			em.persist(m3);
			em.persist(md3);
			em.persist(a3);

		em.getTransaction().commit();
		
		Query qryMarca = em.createQuery("select m from Marca m");
		List<Marca> marcas = qryMarca.getResultList();
		
		Query qryModelo = em.createQuery("select m from Modelo m");
		List<Modelo> modelos = qryModelo.getResultList();
		
		Query qryAutomovel = em.createQuery("select m from Automovel m");
		List<Automovel> autos = qryAutomovel.getResultList();
		
		for (Marca m : marcas) {
			System.out.println("A marca " + m.getNome() + " foi cadastrada com sucesso");
		}
		
		for (Modelo m : modelos) {
			System.out.println("O Modelo " + m.getDescricao() + " foi cadastrado com sucesso");
		}
		
		for (Automovel a : autos) {
			System.out.println("O Automóvel " a.getModelo().getDescricao() + "," + a.getAnoModelo() + " | " + a.getAnoFabricacao() + " foi cadastrado com sucesso");
		}
		
		em.close();
		emf.close();
	}
}
