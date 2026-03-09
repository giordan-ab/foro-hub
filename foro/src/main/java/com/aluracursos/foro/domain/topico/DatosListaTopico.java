package com.aluracursos.foro.domain.topico;

import java.time.LocalDate;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        Status status,
        String autor, // Aquí devolvemos el nombre del usuario
        String curso  // Aquí devolvemos el nombre del curso
) {
        public DatosListaTopico(Topico topico) {
            this(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getStatus(),
                    topico.getAutor().getNombre(), // Extrae el nombre del objeto Usuario
                    topico.getCurso().getNombre()   // Extrae el nombre del objeto Curso
            );
        }
}
