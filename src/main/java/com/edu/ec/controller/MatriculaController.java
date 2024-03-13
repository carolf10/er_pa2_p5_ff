package com.edu.ec.controller;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.edu.ec.service.IMatriculaService;
import com.edu.ec.service.to.MatriculaTO;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	@Autowired
	private IMatriculaService matriculaService;
	
	@GetMapping("/mostrarFormularioMatriculas")
	public String mostrar(Model model) {
		model.addAttribute("matritulaTO", new MatriculaTO());
		return "formularioMatricula";
	}
	
	@PostMapping("/registrarMatricula")
	public String registrar (@ModelAttribute("matritulaTO")MatriculaTO matriculaTO,Model model) {
		Predicate<MatriculaTO> validar = matr -> !matr.getCedula().isEmpty() && !matr.getCodigo().isEmpty();
		List<MatriculaDTO> matriculas = null;
		if(validar.test(matriculaTO)) {
			this.matriculaService.matricularEstudiante(matriculaTO);
			matriculas= this.matriculaService.reportarTodo();
			model.addAttribute("matriculas",matriculas);
			return "reporteMatriculas";
		}else {
			return "redirect:/matriculas/mostrarFormularioMatriculas";
		}
	}
}
