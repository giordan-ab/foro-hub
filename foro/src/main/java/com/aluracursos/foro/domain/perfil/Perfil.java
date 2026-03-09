package com.aluracursos.foro.domain.perfil;

import jakarta.persistence.*;

@Table(name = "perfiles")
@Entity(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // e.g., "ROLE_ADMIN", "ROLE_USER"
}
