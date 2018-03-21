package p07;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class GetEmployeeWithProject {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(reader.readLine());

        List<Employee> employee = em.createQuery("select e from Employee AS e where e.id=:id").setParameter("id", id).getResultList();

        Employee emp = employee.get(0);
        StringBuilder sb = new StringBuilder();

        sb.append(emp.getFirstName()).append(" ").append(emp.getLastName()).append(" - ").append(emp.getJobTitle())
                .append(System.lineSeparator());
        emp.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> sb.append("   ").append(p.getName()).append(System.lineSeparator()));

        System.out.println(sb.toString());

        em.close();
        emf.close();
    }
}