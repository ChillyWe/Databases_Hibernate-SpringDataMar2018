package core;

import models.BaseLabel;
import models.ingredients.AmmoniumChloride;
import models.ingredients.BaseIngredient;
import models.ingredients.Mint;
import models.ingredients.Nettle;
import models.shampoos.BaseShampoo;
import models.shampoos.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shampoos_db");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        BaseIngredient am = new AmmoniumChloride();
        BaseIngredient mint = new Mint();
        BaseIngredient nettle = new Nettle();

        BaseLabel label = new BaseLabel("Fresh Nuke Shampoo", "Contains mint and nettle");

        BaseShampoo shampoo = new FreshNuke(label);

        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(am);
        em.persist(shampoo);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}