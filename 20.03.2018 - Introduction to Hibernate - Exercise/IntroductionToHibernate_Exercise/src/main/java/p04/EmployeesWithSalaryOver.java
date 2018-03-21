package p04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesWithSalaryOver {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        List<String> resultList = em.createQuery("SELECT e.firstName from Employee AS e WHERE e.salary >= 50000").getResultList();

        for (String firstName : resultList) {
            System.out.println(firstName);
        }
        em.close();
        emf.close();
    }
}