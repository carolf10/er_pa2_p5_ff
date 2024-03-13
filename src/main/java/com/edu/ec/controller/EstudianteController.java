package com.edu.ec.controller;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.ec.repository.modelo.Estudiante;
import com.edu.ec.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping("/mostrarFormularioEstudiante")
	public String mostrar(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "formularioEstudiante";
	}
	
	@PostMapping ("/registrarEstudiantes")
	public String registrar (@ModelAttribute("estudiante")Estudiante estudiante) {
		Predicate<Estudiante> validar= estu -> !estu.getApellido().isEmpty() && !estu.getCedula().isEmpty() && !estu.getNombre().isEmpty() && !estu.getFechaNacimiento().isEmpty();
		
		if (validar.test(estudiante)) {
			this.estudianteService.guardar(estudiante);
			return "redirect:/estudiantes/mostrarFormularioEstudiante";
		}else {
			return "redirect:/estudiantes/mostrarFormularioEstudiante";
		}
		
	}
}
