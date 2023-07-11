package com.tpa.toyproject_api.Board.Data.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    Integer views;
    @Column(nullable = false)
    Integer up;
}
