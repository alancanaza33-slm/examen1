package com.examen.mascotas.service;

import com.examen.mascotas.model.Mascota;
import com.examen.mascotas.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> obtenerTodas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> obtenerPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Optional<Mascota> actualizar(Long id, Mascota detalles) {
        return mascotaRepository.findById(id).map(mascota -> {
            mascota.setNombre(detalles.getNombre());
            mascota.setEspecie(detalles.getEspecie());
            mascota.setEdad(detalles.getEdad());
            mascota.setPeso(detalles.getPeso());
            return mascotaRepository.save(mascota);
        });
    }

    public boolean eliminar(Long id) {
        return mascotaRepository.findById(id).map(mascota -> {
            mascotaRepository.delete(mascota);
            return true;
        }).orElse(false);
    }
}