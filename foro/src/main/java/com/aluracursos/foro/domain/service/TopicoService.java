package com.aluracursos.foro.domain.service;

import com.aluracursos.foro.domain.topico.DatosActualizacionTopico;
import com.aluracursos.foro.domain.topico.DatosDetalleTopico;
import com.aluracursos.foro.domain.topico.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public DatosDetalleTopico actualizarTopico(Long id, DatosActualizacionTopico datos) {
        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            var topico = optionalTopico.get();
            topico.actualizarInformaciones(datos);
            return new DatosDetalleTopico(topico);
        }

        // Si no existe, puedes lanzar una excepción personalizada
        throw new EntityNotFoundException("El tópico con ID " + id + " no existe.");
    }

    // --- DELETE LOGIC (Hard Delete) ---
    @Transactional
    public void eliminarTopico(Long id) {
        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            repository.deleteById(id); // Required by the instruction
        } else {
            throw new EntityNotFoundException("No se puede eliminar: el tópico con id " + id + " no existe.");
        }
    }
}
