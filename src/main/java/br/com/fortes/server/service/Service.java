package br.com.fortes.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fortes.server.model.FilmeModel;
import br.com.fortes.server.negocio.FilmeNegocio;

@RestController
@RequestMapping(value = "/api")
public class Service {

	@Autowired
	private FilmeNegocio filmeNegocio;

	@GetMapping(value = "/filmes")
	public ResponseEntity filmesDisponiveis() {
		try {
			List<FilmeModel> lista = filmeNegocio.obterTodos(FilmeModel.class);
			return ResponseEntity.ok().body(lista);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		}

	}

}
