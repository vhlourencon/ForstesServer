package br.com.fortes.server.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fortes.server.model.FilmeModel;
import br.com.fortes.server.model.ReservaModel;
import br.com.fortes.server.negocio.FilmeNegocio;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Service {

	@Autowired
	private FilmeNegocio filmeNegocio;

	@GetMapping(value = "/filmes")
	public ResponseEntity<List<FilmeModel>> filmesDisponiveis() {
		try {
			List<FilmeModel> lista = (ArrayList<FilmeModel>) filmeNegocio.obterTodos(FilmeModel.class);
			return ResponseEntity.ok().body(lista);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}
	
	@PostMapping(value = "/filmes/salvar")
	public ResponseEntity<FilmeModel> salvar(@RequestBody FilmeModel filmeModel) {
		try {
			if( filmeModel.getId() == null ) { 
			  
			  filmeNegocio.salvar(filmeModel);
			} else { 
				filmeNegocio.alterar(filmeModel);
			}
			return ResponseEntity.ok().body(filmeModel);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}
	
	
	@PostMapping(value = "/filmes/alugar")
	public ResponseEntity<FilmeModel> alugar(@RequestBody FilmeModel filmeModel) {
		try {
			filmeModel.setAlugado(true);
			filmeNegocio.alterar(filmeModel);
			return ResponseEntity.ok().body(filmeModel);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}
	
	@DeleteMapping(value = "/filmes/deletar/{id}")
	public ResponseEntity deletar(@PathVariable Long id  ) {
		try {
			filmeNegocio.excluir(filmeNegocio.obterPorId(FilmeModel.class, id));
			System.out.println("excluir");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}
	
	@PostMapping(value = "/filmes/devolver")
	public ResponseEntity<FilmeModel> devolver(@RequestBody FilmeModel filmeModel) {
		try {
			filmeModel.setAlugado(false);
			filmeModel.setDataDevolucao(null);
			filmeNegocio.alterar(filmeModel);
			return ResponseEntity.ok().body(filmeModel);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

	@GetMapping(value = "/filmes/{id}")
	public ResponseEntity<FilmeModel> obterPorId(@PathVariable Long id) {
		try {
			FilmeModel filmeModel =  filmeNegocio.obterPorId(FilmeModel.class,id);
			
			
			return ResponseEntity.ok().body(filmeModel);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

}
