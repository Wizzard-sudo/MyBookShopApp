package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.dto.relationship.Book2Genre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "parent_id")
    private Integer parentId;
    @NotNull
    private String slug;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Book2Genre> book2Genres = new ArrayList<>();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parentId;
    }

    public void setParent_id(Integer parentId) {
        this.parentId = parentId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", parent_id=" + parentId +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
