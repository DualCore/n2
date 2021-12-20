package br.com.luisurnau.n2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chars")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "char(50) not null", unique = true)
    private String name;
    @Column(columnDefinition = "varchar(20) not null")
    private String element;
    @Column(columnDefinition = "varchar(20) not null")
    private String city;
    @Column(columnDefinition = "varchar(20) not null")
    private String weapon;

    public Character(int id, String name, String element, String city, String weapon) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.city = city;
        this.weapon = weapon;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

}