package p12;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        List<Object[]> departmentsSalaries = em.createQuery("SELECT d.name, MAX(e.salary) FROM Department AS d " +
                "INNER JOIN d.employees AS e " +
                "GROUP BY d.name " +
                "HAVING MAX(e.salary) < 30000 OR MAX(e.salary) > 70000").getResultList();

        for (Object[] dept : departmentsSalaries) {
            System.out.println(String.format("%s - %.2f", dept[0], (BigDecimal) dept[1]).replace(",", "."));
        }
    }
}