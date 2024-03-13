package com.project.restapi.modelando;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empleado")
@Data
public class modelando {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
