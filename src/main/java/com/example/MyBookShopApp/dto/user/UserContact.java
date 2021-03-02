package com.example.MyBookShopApp.dto.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "user_contact")
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @NotNull
    @Column(columnDefinition = "varchar(255)")
    private String type;
    @NotNull
    private short approved;
    private String code;
    private Integer code_trials;
    @Column(columnDefinition = "timestamp")
    private Date code_time;
    @NotNull
    private String contact;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getApproved() {
        return approved;
    }

    public void setApproved(short approved) {
        this.approved = approved;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCode_trials() {
        return code_trials;
    }

    public void setCode_trials(Integer code_trials) {
        this.code_trials = code_trials;
    }

    public Date getCode_time() {
        return code_time;
    }

    public void setCode_time(Date code_time) {
        this.code_time = code_time;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "UserContact{" +
                "id=" + id +
                ", user=" + user +
                ", type=" + type +
                ", approved=" + approved +
                ", code='" + code + '\'' +
                ", code_trials=" + code_trials +
                ", code_time=" + code_time +
                ", contact='" + contact + '\'' +
                '}';
    }
}
