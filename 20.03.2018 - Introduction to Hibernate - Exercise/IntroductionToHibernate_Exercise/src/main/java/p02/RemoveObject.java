package p02;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RemoveObject {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager entityManager = emf.createEntityManager();

        List<Town> towns = entityManager.createQuery("SELECT t FROM Town AS t").getResultList();

        entityManager.getTransaction().begin();
        for (Town town : towns) {
            if (town.getName().length() > 5) {
                town.setName(town.getName().toLowerCase());
            }
        }
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
        String debug = "";
    }
}