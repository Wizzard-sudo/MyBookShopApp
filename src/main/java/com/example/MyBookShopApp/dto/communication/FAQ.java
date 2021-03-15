package com.example.MyBookShopApp.dto.communication;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "faq")
public class FAQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "sort_index", columnDefinition = "integer default 0")
    private Integer sortIndex;
    @NotNull
    private String question;
    @NotNull
    @Column(columnDefinition = "text")
    private String answer;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "FAQ{" +
                "id=" + id +
                ", sort_index=" + sortIndex +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
