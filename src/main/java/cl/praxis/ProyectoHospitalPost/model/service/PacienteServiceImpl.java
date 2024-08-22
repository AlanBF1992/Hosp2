package cl.praxis.ProyectoHospitalPost.model.service;

import cl.praxis.ProyectoHospitalPost.model.dto.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final List<Paciente> pacientes;

    public PacienteServiceImpl() {
        pacientes = new ArrayList<Paciente>();
        save(new Paciente("Luis", true));
        save(new Paciente("María", false));
        save(new Paciente("Alejandra", true));
    }

    @Override
    public List<Paciente> findAll() {
        return pacientes;
    }

    @Override
    public Paciente findById(int id) {
        return pacientes.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
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

    @Override
    public boolean update(Paciente paciente) {
        System.out.println("El id es: " + paciente.getId());
        int index = IntStream.range(0, pacientes.size()).filter(i -> pacientes.get(i).getId() == paciente.getId()).findFirst().orElse(-1);

        System.out.println("El index es: " + index);
        if (index == -1) {
            return false;
        }
        pacientes.set(index, paciente);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int index = IntStream.range(0, pacientes.size()).filter(i -> pacientes.get(i).getId() == id).findFirst().orElse(-1);

        if (index == -1) {
            return false;
        }
        pacientes.remove(index);
        return true;
    }
}
