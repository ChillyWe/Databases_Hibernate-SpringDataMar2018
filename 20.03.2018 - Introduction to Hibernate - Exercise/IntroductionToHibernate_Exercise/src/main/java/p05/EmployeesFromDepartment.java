package p05;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        List<Employee> employees = em.createQuery("select e from Employee As e where e.department.name = 'Research and Development'" +
                " order by e.salary ASC, e.id ASC ").getResultList();

        String debug = "";
        for (Employee employee : employees) {
            System.out.println(String.format("%s %s from %s - $%.2f",
                    employee.getFirstName(), employee.getLastName(), employee.getDepartment().getName(), employee.getSalary())
            .replace(",", "."));
        }

        em.close();
        emf.close();
    }
}