package com.aluracursos.foro.domain.respuesta;

import com.aluracursos.foro.domain.topico.Topico;
import com.aluracursos.foro.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico; // Relación FK con Tópico

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor; // Relación FK con Usuario

    private Boolean solucion = false; // Por defecto ninguna respuesta es la solución

}
