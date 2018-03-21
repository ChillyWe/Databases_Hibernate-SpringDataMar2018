package p06;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Address address = new Address();
        address.setText("Vitoshka 15");
        em.persist(address);
        em.getTransaction().commit();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lastName = reader.readLine();
        List<Employee> employee = em.createQuery("SELECT e FROM Employee AS e WHERE e.lastName =:lastName")
                .setParameter("lastName", lastName).getResultList();

        em.getTransaction().begin();
        employee.get(0).setAddress(address);
        em.getTransaction().commit();

        String debug = "";
        em.close();
        emf.close();
    }
}