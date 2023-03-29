package br.com.senac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Estudante;
import br.com.senac.reposiroty.EstudanteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EstudanteService {

	//private static Map<Long, Estudante> listaEstudantes = new HashMap<>();

	private EstudanteRepository estudanteRepository;
	
	public ResponseEntity<Estudante> buscarEstudantePorId(Long id){
		
		if(estudanteRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(estudanteRepository.findById(id).get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		//Estudante estudante = listaEstudantes.get(id);
		//if (estudante == null) {
			//return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			//}
		//return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		
		List<Estudante> listaEstudante = estudanteRepository.findAll();
		if (listaEstudante != null) {
			return ResponseEntity.status(HttpStatus.OK).body(listaEstudante);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		//List listaEstudante = new ArrayList<Estudante>(listaEstudantes.values());
		//if(listaEstudante.isEmpty()) {
		//return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		//}
		//return ResponseEntity.status(HttpStatus.OK).body(listaEstudante);
	}
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
		Estudante est = estudanteRepository.save(estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(est);
	}
	
	
	public ResponseEntity<Estudante> atualizarEstudante(Long id,Estudante estudante){
		
		if(estudanteRepository.existsById(id)) {
			Estudante est = estudanteRepository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(est);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		//Estudante estudanteEncontrado = listaEstudantes.get(id);
		//if(estudanteEncontrado == null) {
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		//}
		//listaEstudantes.put(estudante.getId(), estudante);
		//return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	public ResponseEntity<String> removerUsuario(long id){
		
		if(estudanteRepository.existsById(id)) {
			estudanteRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Estudante excluído com sucesso!");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não existe!");
		
		
		//Estudante estudanteEncontrado = listaEstudantes.get(id);
		//if(estudanteEncontrado == null) {
		//	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		//}
		
		//listaEstudantes.remove(id);
		//return ResponseEntity.status(HttpStatus.OK).body("Removido com sucesso!");
	}
	
	public Page<Estudante> buscaEstudantePorPaginacao(PageRequest page){
		return estudanteRepository.findAll(page);
	}
	
}