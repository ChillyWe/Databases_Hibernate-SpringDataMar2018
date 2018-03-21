package p10;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String townName = bufferedReader.readLine();

        int countRemoveAddress = 0;
        em.getTransaction().begin();
        try {
            Town town = (Town) em.createQuery(String.format("select t from Town t where t.name = '%s'", townName)).getSingleResult();
            List<Address> addresses = em.createQuery(String.format("select a from Address a where a.town.name = '%s'", townName)).getResultList();

            for (Address address : addresses) {
                em.remove(address);
                countRemoveAddress++;
            }
            em.remove(town);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        System.out.println(String.format("%d address in %s was deleted", countRemoveAddress, townName));

        em.close();
        emf.close();
    }
}