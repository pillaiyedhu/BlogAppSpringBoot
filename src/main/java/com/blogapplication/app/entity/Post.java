package com.blogapplication.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title",length = 1000,nullable = false)
    private String title;
    @Column(name="caption",length = 10000,nullable = true)
    private String caption;
    private Date createdDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

}
