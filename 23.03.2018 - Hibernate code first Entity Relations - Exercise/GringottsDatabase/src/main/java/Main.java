import entities.WizardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicWandCreator("Antoich Peverell");
        Short magicWandSize = 15;
        dumbledore.setMagicWandSize(magicWandSize);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,10,20);
        Date depositStart = calendar.getTime();
        dumbledore.setDepositStartDate(depositStart);
        calendar.set(2020,10,20);
        Date depositEnd = calendar.getTime();
        dumbledore.setDepositExpirationDate(depositEnd);
        dumbledore.setDepositAmount(BigDecimal.valueOf(2000.24));
        dumbledore.setDepositCharge(BigDecimal.valueOf(0.2));
        dumbledore.setIsDepositExpired(false);
        em.persist(dumbledore);

        WizardDeposit amblefore = new WizardDeposit();
        amblefore.setFirstName("Broko");
        amblefore.setLastName("Amblefore");
        amblefore.setAge(12);
        amblefore.setMagicWandCreator("Piontich Gingile");
        Short ambleforeMagicWandSize = 3456;
        amblefore.setMagicWandSize(ambleforeMagicWandSize);
        calendar.set(2015,11,20);
        Date ambleforeDepositStart = calendar.getTime();
        amblefore.setDepositStartDate(ambleforeDepositStart);
        calendar.set(2019,11,20);
        Date ambleforeDepositEnd = calendar.getTime();
        amblefore.setDepositExpirationDate(ambleforeDepositEnd);
        amblefore.setDepositAmount(BigDecimal.valueOf(100.62));
        amblefore.setDepositCharge(BigDecimal.valueOf(0.2));
        amblefore.setIsDepositExpired(false);
        em.persist(amblefore);

        WizardDeposit fitipore = new WizardDeposit();
        fitipore.setFirstName("Lori");
        fitipore.setLastName("Fitipore");
        fitipore.setAge(324);
        fitipore.setMagicWandCreator("Grifindale Prah");
        Short fitiporeMagicWandSize = 128;
        fitipore.setMagicWandSize(fitiporeMagicWandSize);
        calendar.set(2016,8,20);
        Date fitiporeDepositStart = calendar.getTime();
        fitipore.setDepositStartDate(fitiporeDepositStart);
        calendar.set(2018,8,18);
        Date fitiporeDepositEnd = calendar.getTime();
        fitipore.setDepositExpirationDate(fitiporeDepositEnd);
        fitipore.setDepositAmount(BigDecimal.valueOf(1200.81));
        fitipore.setDepositInterest(BigDecimal.valueOf(0.05));
        fitipore.setDepositCharge(BigDecimal.valueOf(0.2));
        fitipore.setIsDepositExpired(false);
        em.persist(fitipore);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
