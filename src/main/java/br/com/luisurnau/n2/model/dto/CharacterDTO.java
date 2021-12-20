package br.com.luisurnau.n2.model.dto;

public class CharacterDTO {
    private int id;
    private String name;
    private String element;
    private String city;
    private String weapon;

    public CharacterDTO(int id, String name, String element, String city, String weapon) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.city = city;
        this.weapon = weapon;
    }
    
    public CharacterDTO() {

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
