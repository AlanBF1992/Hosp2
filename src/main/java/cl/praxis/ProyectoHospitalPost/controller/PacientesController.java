package cl.praxis.ProyectoHospitalPost.controller;

import cl.praxis.ProyectoHospitalPost.model.dto.Paciente;
import cl.praxis.ProyectoHospitalPost.model.service.PacienteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PacientesController {

    PacienteServiceImpl pacienteService;
    Logger LOG = LoggerFactory.getLogger(PacientesController.class);

    public PacientesController (PacienteServiceImpl pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("pacientes")
    public String pacientesGet(Model model) {
        LOG.info("PacientesController: enviando pacientes a la vista");
        model.addAttribute("pacientes", pacienteService.findAll());
        return "pacientes";
    }

    @PostMapping(value = "pacientes/delete", params = "id")
    public String deletePaciente(@RequestParam("id") int id) {
        pacienteService.delete(id);
        return "redirect:/pacientes";
    }

    @GetMapping("pacientes/create")
    public String createPaciente(Model model) {
        return "paciente";
    }

    @PostMapping("pacientes/create")
    public String createPaciente(@ModelAttribute("paciente") Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping(value = "pacientes/update", params = "id")
    public String updatePaciente(@RequestParam("id") int id, Model model) {
        Paciente paciente = pacienteService.findById(id);
        model.addAttribute("paciente", paciente);
        return "updatePaciente";
    }

    @PostMapping("pacientes/update")
    public String updatePaciente(@ModelAttribute("paciente") Paciente paciente, @RequestParam("id") int id) {
        paciente.setId(id);
        pacienteService.update(paciente);
        return "redirect:/pacientes";
    }
}
