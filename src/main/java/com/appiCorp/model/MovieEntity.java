package com.appiCorp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "movies")
@Data
public class MovieEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    @Column(name = "`year`")
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
}

