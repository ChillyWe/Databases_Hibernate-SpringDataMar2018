package p11;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmployeesByFirstName {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern = reader.readLine();
        pattern += "%";

        List<Employee> employees = em.createQuery("select e FROM  Employee AS e where e.firstName LIKE :pattern")
                .setParameter("pattern", pattern).getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s - %s ($%.2f)",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary()));
        }

        em.close();
        emf.close();
    }
}