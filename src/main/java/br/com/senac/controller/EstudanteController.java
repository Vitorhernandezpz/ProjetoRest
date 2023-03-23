package br.com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.domain.Estudante;
import br.com.senac.service.EstudanteService;

@RestController
@RequestMapping("estudante")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id){
		return estudanteService.buscarEstudantePorId(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		return estudanteService.buscarTodosEstudantes();
	}
	
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante){
		return estudanteService.cadastrarEstudante(estudante);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id,@RequestBody Estudante estudante){
		return estudanteService.atualizarEstudante(id,estudante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerEstudante(@PathVariable Long id){
		return estudanteService.removerUsuario(id);
	}
}
