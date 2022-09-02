package com.CycleTeam.sistemacontable.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String image;
    private String phone;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
