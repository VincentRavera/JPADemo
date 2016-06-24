package fr.treeptik.runtime;



import java.util.List;

//import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
//import javax.persistence.Query;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
import javax.persistence.TypedQuery;

//import fr.treeptik.jpasample.model.Adresse;
import fr.treeptik.jpasample.model.Personne;

public class Runtime {

	private static EntityManager eN;

	public static void main(String[] args) {
		
		eN = Persistence.createEntityManagerFactory("sample").createEntityManager();
		
//		Personne personne = new Personne();
//		personne.setNom("BeauRegard");
//		personne.setPrenom("Jack");
//		personne.setDateNaissance(new Date());
//		personne.setSexe("M");
//		Adresse adresse = new Adresse();
//		adresse.setRue("bd Gigot");
//		adresse.setVille("Tho");
//		
//		personne.setAdresse(adresse);
		
		try{
//			eN.getTransaction().begin();
//			eN.persist(adresse);
//			eN.persist(personne);
//			eN.getTransaction().commit();
			
			
//			personne = eN.find(Personne.class, 1);
//			personne.setPrenom("jacques");
//			eN.getTransaction().begin();
//			eN.remove(personne);
			
//			eN.getTransaction().commit();
			
			
		}catch(PersistenceException e){
			e.printStackTrace();
			eN.getTransaction().rollback();
			
		}
		
		Personne personne2 = new Personne();
		personne2.setNom("BeauRegard");
//		Query query = 
//				eN.createQuery("SELECT p FROM Personne p WHERE p.nom=:name");
//		TypedQuery<Personne> query = 
//				eN.createQuery("SELECT p FROM Personne p WHERE p.nom=:name", Personne.class);
//		TypedQuery<Personne> query = 
//				eN.createNamedQuery("requete1", Personne.class);
//		Query query = 
//				eN.createNativeQuery("SELECT * from Personne where nom = :name",
//						Personne.class);
//		query.setMaxResults(2);
		
//		query.setParameter("name", personne2.getNom());
		
		
		
		
		
		TypedQuery<Personne> query =
				eN.createQuery("SELECT p FROM Personne p "
						+ "left join fetch p.adresse "
						+ "WHERE p.id = :id",
						Personne.class);
		query.setParameter("id", 14);
		List<Personne> resultList = query.getResultList();
		eN.close();
		
		for (Personne p : resultList) {
			System.out.println("res = "+p);
			System.out.println("jjqshgdiq"+p.getAdresse());
			
		}
		
		
		
		
		
		
		

	}

}
