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

import com.edu.ec.repository.modelo.Materia;
import com.edu.ec.service.IMateriaService;
import com.edu.ec.service.to.MateriaTO;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping("/mostrarFormularioMaterias")
	public String mostrar(Model model) {
		model.addAttribute("materiaTO", new MateriaTO());
		return "formularioMateria";
	}
	
	@PostMapping("/registrarMaterias")
	public String registrar(@ModelAttribute("materiaTO")MateriaTO materiaTO, Model model) {
		Predicate<MateriaTO> validar = mat -> !mat.getCodigo().isEmpty() && !mat.getDescripcion().isEmpty() && !mat.getNombre().isEmpty() && !mat.getNumeroCreditos().isEmpty();
		List<Materia> materias = null;
		if (validar.test(materiaTO)) {
			this.materiaService.guardar(materiaTO);
			materias= this.materiaService.reportarTodo();
			model.addAttribute("materias", materias);
			return "listadoMaterias";
		}else {
			return "redirect:/materias/mostrarFormularioMaterias";
		}
	}
	
}
