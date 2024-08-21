package cl.praxis.ProyectoHospitalPost.model.service;

import cl.praxis.ProyectoHospitalPost.model.dto.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final List<Paciente> pacientes;

    public PacienteServiceImpl() {
        pacientes = new ArrayList<Paciente>();
        save(new Paciente(1, "Luis", true));
        save(new Paciente(2, "María", false));
        save(new Paciente(3, "Alejandra", true));
    }

    @Override
    public List<Paciente> findAll() {
        return pacientes;
    }

    @Override
    public Paciente findById(int id) {
        return null;
    }

    @Override
    public boolean save(Paciente paciente) {
        if (paciente.getId() == 0) {
            paciente.setId(pacientes.stream().map(Paciente::getId).max(Integer::compareTo).orElse(0) + 1);
        }
        try {
            pacientes.add(paciente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
