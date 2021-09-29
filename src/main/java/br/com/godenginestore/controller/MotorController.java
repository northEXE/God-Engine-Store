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

import br.com.godenginestore.dto.MotorDTO;
import br.com.godenginestore.exception.RegraNegocioException;
import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Motor;
import br.com.godenginestore.services.MarcaService;
import br.com.godenginestore.services.MotorService;

@RestController
@RequestMapping(path = "/api/motor")
public class MotorController {
	
	@Autowired
	MotorService motorService;
	
	@Autowired
	MarcaService marcaService;
	
	@PostMapping(path = "/salvar/")
	public ResponseEntity<Object> salvarMotor(@RequestBody MotorDTO motorDTO){
		
		try {
			Motor entidade = converter(motorDTO);
			entidade = motorService.cadastrarMotor(entidade);
			motorService.addMotorNaMarca(entidade.getFabricante().getIdMarca(), entidade);
			return new ResponseEntity<Object>(entidade, HttpStatus.CREATED);
		}catch(RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public List<MotorDTO> listarMotores(){
		return motorService.listarTodosOsMotores();
	}
	
	@PutMapping(path = "/{idMotor}/alterar/")
	public ResponseEntity<? extends Object> alterarMotor(@PathVariable Integer idMotor, @RequestBody MotorDTO motorDTO){
		return motorService.buscarMotorPorIdOptional(idMotor).map(entidade -> {
			try {
				Motor motor = converter(motorDTO);
				motor.setIdMotor(entidade.getIdMotor());
				Motor motorAlterado = motorService.editarMotorNaMarca(motor.getFabricante().getIdMarca(), idMotor, motor);
				return ResponseEntity.ok(motorAlterado);
			}catch(RegraNegocioException e){
				return ResponseEntity.badRequest().body(e);
			}
		}).orElseGet(() -> new ResponseEntity<Object>("Motor não encontrado.", HttpStatus.BAD_REQUEST));
	}
	
	private Motor converter(MotorDTO motorDTO) {
		
		Motor motor = new Motor();
		motor.setCodigoMotor(motorDTO.getCodigoMotor());
		motor.setNomeMotor(motorDTO.getNomeMotor());
		motor.setCilindrada(motorDTO.getCilindrada());
		motor.setDescricaoMotor(motorDTO.getDescricaoMotor());
		motor.setModelosAplicados(null);
		
		Marca marca = marcaService
				.buscarPorIdOptional(motorDTO.getFabricante())
				.orElseThrow(() -> new RegraNegocioException("Marca não encontrada. Por favor, verifique novamente"));
		
		motor.setFabricante(marca);
		
		return motor;
	}
}
