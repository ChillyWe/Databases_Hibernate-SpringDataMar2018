package models;

import contacts.Label;
import models.shampoos.BaseShampoo;

import javax.persistence.*;

@Entity
@Table(name = "labels")
public class BaseLabel implements Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    private String title;

    @Basic
    private String subtitle;

    @OneToOne(mappedBy = "label", targetEntity = BaseShampoo.class, cascade = CascadeType.ALL)
    private BaseShampoo baseShampoo;

    public BaseLabel() {
    }

    public BaseLabel(String title, String subtitle) {
        setTitle(title);
        setSubtitle(subtitle);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}