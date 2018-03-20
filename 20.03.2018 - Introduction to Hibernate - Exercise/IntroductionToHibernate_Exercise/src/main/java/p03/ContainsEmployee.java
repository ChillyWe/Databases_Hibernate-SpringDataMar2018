package p03;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] name = reader.readLine().split("\\s+");
        String firstName = name[0];
        Query employeeQuery = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName =:pattern");
        employeeQuery.setParameter("pattern", firstName);
        List<Employee> employees = employeeQuery.getResultList();

        System.out.println(employees.size() > 0);

        em.close();
        emf.close();
    }
}