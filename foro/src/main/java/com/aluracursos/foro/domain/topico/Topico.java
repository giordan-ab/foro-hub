package com.aluracursos.foro.domain.topico;

import com.aluracursos.foro.domain.curso.Curso;
import com.aluracursos.foro.domain.respuesta.Respuesta;
import com.aluracursos.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor; // Relación N:1 con Usuario

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso; // Relación N:1 con Curso

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas; // Colección para acceder a las respuestas

    public Topico(@Valid DatosRegistroTopico datos, Usuario autor, Curso curso) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDate.now();
        this.status = Status.NO_RESPONDIDO; // Or your default status
        this.autor = autor; // This fills the autor_id in DB
        this.curso = curso; // This fills the curso_id in DB
    }

    // Inside Topico.java

    public void actualizarInformaciones(DatosActualizacionTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        // Optional: you could also allow updating the status if needed
        if (datos.status() != null) {
            this.status = datos.status();
        }
    }

    public void eliminar() {
    }
}
