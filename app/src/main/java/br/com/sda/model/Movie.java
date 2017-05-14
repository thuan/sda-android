package br.com.sda.model;

import java.io.Serializable;

public class Movie implements Serializable {

    private Integer id;
    private String name;
    private String author;
    private String description;
    private Boolean favorite;

    public Movie() {
    }

    public Movie(Integer id, String name, String author, String description, Boolean favorite) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.favorite = favorite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}
