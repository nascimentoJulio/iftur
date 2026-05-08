package br.com.ifsul.iftur.domains;

public class Destination {
    public String name;
    public String description;
    public String image;
    public String country;
    private Integer id;

    public Destination(String name, String description, String image, String country, Integer id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.country = country;
        this.id = id;
    }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
