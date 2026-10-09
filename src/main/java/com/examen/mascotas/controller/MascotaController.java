package com.examen.mascotas.controller;

import com.examen.mascotas.model.Mascota;
import com.examen.mascotas.repository.MascotaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@Tag(name = "Mascotas", description = "API REST para administración de mascotas")
public class MascotaController {

    private final MascotaRepository mascotaRepository;

    public MascotaController(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las mascotas")
    public List<Mascota> obtenerTodas() {
        return mascotaRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una mascota por ID")
    public Mascota obtenerPorId(@PathVariable Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva mascota")
    public Mascota crear(@RequestBody Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una mascota por ID")
    public Mascota actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        mascota.setId(id);
        return mascotaRepository.save(mascota);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una mascota por ID")
    public void eliminar(@PathVariable Long id) {
        mascotaRepository.deleteById(id);
    }
}