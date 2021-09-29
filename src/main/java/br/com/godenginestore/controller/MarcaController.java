package br.com.godenginestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.godenginestore.dto.MarcaDTO;
import br.com.godenginestore.dto.MotorDTO;
import br.com.godenginestore.exception.RegraNegocioException;
import br.com.godenginestore.model.Marca;
import br.com.godenginestore.services.MarcaService;
import br.com.godenginestore.services.MotorService;

@RestController
@RequestMapping(path = "/api/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private MotorService motorService;

	@PutMapping(path = "/salvar")
	public ResponseEntity<Object> salvarMarca(@RequestBody MarcaDTO marcaDTO) {
		Marca marca = Marca.builder().nomeMarca(marcaDTO.getNomeMarca()).build();
		try {
			Marca marcaSalva = marcaService.cadastrarMarca(marca);
			return new ResponseEntity<Object>(marcaSalva, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e);
		}
	}


	@GetMapping
	public ResponseEntity<Object> buscarMarca(@RequestParam(value = "nomeMarca", required = false) String nomeMarca) {
		Marca marcaFiltro = new Marca();
		marcaFiltro.setNomeMarca(nomeMarca);

		List<Marca> marcas = marcaService.buscarPorNome(marcaFiltro);
		return ResponseEntity.ok(marcas);
	}

	@GetMapping(path = "/{idMarca}/listar-motores")
	public ResponseEntity<Object> listarMotoresMarca(@PathVariable Integer idMarca) {
		List<MotorDTO> motoresDaMarca = motorService.listarMotoresPorMarca(idMarca);
		if(motoresDaMarca.size() == 0) {
			return ResponseEntity.badRequest().body("Não há motores cadastrados nesta marca!");
		}
		return ResponseEntity.ok(motoresDaMarca);
	}
}
