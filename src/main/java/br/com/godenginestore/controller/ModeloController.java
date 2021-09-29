package br.com.godenginestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.godenginestore.dto.ModeloDTO;
import br.com.godenginestore.exception.RegraNegocioException;
import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.model.Motor;
import br.com.godenginestore.services.MarcaService;
import br.com.godenginestore.services.ModeloService;
import br.com.godenginestore.services.MotorService;

@RestController
@RequestMapping(path = "/api/modelo")
public class ModeloController {
	
	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private MotorService motorService;
	
	@PostMapping(path = "/salvar")
	public ResponseEntity<Object> salvarModelo(@RequestBody ModeloDTO modeloDTO){
		try {
			Modelo modelo = converter(modeloDTO);
			Modelo modeloSalvo = modeloService.cadastrarModelo(modelo);
			return ResponseEntity.ok(modeloSalvo);
		}catch(RegraNegocioException e){
			return ResponseEntity.badRequest().body(e);
		}
	}
	
	@GetMapping
	public List<ModeloDTO> listarTodosModelos(){
		return modeloService.getTodosOsModelos();
	}
	
	@PutMapping(path = "/{idModelo}/alterar-modelo")
	public ResponseEntity<? extends Object> alterarModelo(@PathVariable Integer idModelo, @RequestBody ModeloDTO modeloDTO){
		return modeloService.buscarPorIdOptional(idModelo).map(entidade -> {
			try {
				Modelo modelo = converter(modeloDTO);
				modelo.setIdModelo(entidade.getIdModelo());
				Modelo modeloAlterado = modeloService.editarModeloNaMarca(modelo.getMarca().getIdMarca(), idModelo, modelo);
				return ResponseEntity.ok(modeloAlterado);
			}catch(RegraNegocioException e) {
				return ResponseEntity.badRequest().body(e);
			}
		}).orElseGet(() -> new ResponseEntity<Object>("Modelo não encontrado", HttpStatus.BAD_REQUEST));
				
	}
	
	private Modelo converter(ModeloDTO modeloDTO) {
		
		Marca marca = marcaService.buscarPorIdOptional(modeloDTO.getMarca())
				.orElseThrow(() -> new RegraNegocioException("Marca nãoo encontrada."));
		
		Modelo modelo = Modelo.builder()
				.marca(marca)
				.nomeModelo(modeloDTO.getNomeModelo())
				.anosEmFabricacao(modeloDTO.getAnosEmFabricacao())
				.descricaoModelo(modeloDTO.getDescricaoModelo())
				.build();
		
		Motor motor = motorService.buscarMotorPorIdOptional(modeloDTO.getMotor())
				.orElseThrow(() -> new RegraNegocioException("Motor não encontrado na base de dados"));
		
		modelo.setMotor(motor);
		return modelo;
	}
	
}
