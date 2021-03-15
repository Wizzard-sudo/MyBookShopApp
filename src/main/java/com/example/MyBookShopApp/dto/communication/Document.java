package com.example.MyBookShopApp.dto.communication;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "sort_index", columnDefinition = "integer default 0")
    private Integer sortIndex;
    @NotNull
    private String slug;
    @NotNull
    private String title;
    @NotNull
    @Column(columnDefinition = "text")
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort_index() {
        return sortIndex;
    }

    public void setSort_index(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", sort_index=" + sortIndex +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
