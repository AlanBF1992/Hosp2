package cl.praxis.ProyectoHospitalPost.model.service;

import cl.praxis.ProyectoHospitalPost.model.dto.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> findAll();
    Paciente findById(int id);
    boolean save(Paciente paciente);
}
