package p08;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class FindLast10Projects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uniDB");
        EntityManager em = emf.createEntityManager();

        List<Project> projects = em.createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC ")
                .setMaxResults(10).getResultList();

        projects.sort(Comparator.comparing(Project::getName));
        for (Project project : projects) {
            System.out.println(String.format("Project name: %s", project.getName()));
            System.out.println(String.format("  Project Description: %s", project.getDescription()));
            System.out.println(String.format("  Project Start Date:%s", project.getStartDate()));
            System.out.println(String.format("  Project End Date: %s", project.getEndDate()));
        }

        em.close();
        emf.close();
    }
}