package p03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConteinsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        String name = reader.readLine();
        entityManager.createQuery("SELECT e FROM Employee AS e WHERE CONCAT_WC(' ', e.firstName, e.lastName)=:name")
                .setParameter("name", name);


    }
}