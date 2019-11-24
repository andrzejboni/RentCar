package com.pact.rentcar.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String commandContent;
    private Timestamp creationDate;
    private Integer rating;


    @ManyToOne
    AppUser appUser; // TODO to samo co poniżej

    @ManyToOne
    Vehicle vehicle; // TODO trzeba je wszystkie ściągnąć i przypisać jeden do skojarzonego pojazdu !!


}
