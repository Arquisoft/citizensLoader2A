package es.uniovi.asw.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getEntityManager() {
	emf = Persistence.createEntityManagerFactory("CITIZEN");
	em = emf.createEntityManager();
	emf.createEntityManager();

	return em;
    }

    public static void close() {
	emf.close();
	em.close();
    }

}