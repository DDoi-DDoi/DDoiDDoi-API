package com.tpa.toyproject_api.Login.Entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class Member {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id;
    @Column(nullable = false,length = 30)
    private String userName;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false,length = 10)
    private String name;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false,length = 50)
    private String email;
    @ColumnDefault("'user'")
    private String role; // Enum을 써서 Domain 설정 가능 // admin,user,manager
    @CreationTimestamp
    private Timestamp createData;
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", createData=" + createData +
                '}';
    }




}