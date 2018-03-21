package p09;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        List<Employee> employeesForSalaryIncrease = em.createQuery("select e From Employee AS e " +
                "where (e.department.name='Engineering' OR e.department.name='Tool Design'" +
                "OR e.department.name='Marketing' OR e.department.name='Information Services')").getResultList();

        em.getTransaction().begin();
        for (Employee employee : employeesForSalaryIncrease) {
            employee.setSalary(employee.getSalary().multiply(new BigDecimal("1.12")));
            em.persist(employee);
            System.out.println(String.format("%s %s ($%.2f)",
                    employee.getFirstName() , employee.getLastName(), employee.getSalary())
                    .replace(",", "."));
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}