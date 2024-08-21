package cl.praxis.ProyectoHospitalPost.controller;

import cl.praxis.ProyectoHospitalPost.model.service.PacienteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
