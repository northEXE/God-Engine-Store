package br.com.godenginestore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.dto.MotorDTO;
import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.model.Motor;
import br.com.godenginestore.repositories.MotorRepository;

@Service
public class MotorService {
	
	@Autowired
	MotorRepository motorRepository;
	
	@Autowired
	MarcaService marcaService;
	
	@Autowired
	ModeloService modeloService;
	
	public Motor cadastrarMotor(Motor motor) {
		return motorRepository.save(motor);
	}
	
	public List<MotorDTO> listarTodosOsMotores(){
		List<Motor> motores = motorRepository.findAll();
		ArrayList<MotorDTO> listaFiltrada = new ArrayList<MotorDTO>();
		motores.stream().forEach(e -> listaFiltrada.add(converterParaDTO(e)));
		return listaFiltrada;
	}
	
	public Optional<Motor> buscarMotorPorIdOptional(Integer idMotor) {
		return motorRepository.findById(idMotor);
	}
	
	public Motor buscarMotorPorId(Integer idMotor) {
		return motorRepository.getById(idMotor);
	}
	
	public Motor buscarPorCodigoMotor(String codigoMotor) {
		return motorRepository.findByCodigoMotor(codigoMotor);
	}
	
	public void removerMotor(String codigoMotor) {
		motorRepository.delete(motorRepository.findByCodigoMotor(codigoMotor));
	}
	
	public void addMotorNaMarca(Integer idMarca, Motor motor) {
		Marca marca = marcaService.buscarPorId(idMarca);
		motor.setFabricante(marca);
		marca.getMotores().add(motor);
		
		marcaService.cadastrarMarca(marca);
		motorRepository.save(motor);
	}
	
	public void addMotorDoModelo(Integer idModelo, Motor motor) {
		Modelo modelo = modeloService.buscarPorId(idModelo);
		modelo.setMotor(motor);
		
		modeloService.cadastrarModelo(modelo);
		motorRepository.save(motor);
	}
	
	public Motor editarMotorNaMarca(Integer idMarca, Integer idMotor, Motor motorModificado) {
		Marca marca = marcaService.buscarPorId(idMarca);
		Motor motor = motorRepository.getById(idMotor);
		marca.getMotores().remove(motor);
		marcaService.cadastrarMarca(marca);
		
		marca.getMotores().add(motorModificado);
		marcaService.cadastrarMarca(marca);
		return motorRepository.save(motorModificado);
		
	}
	
	public List<MotorDTO> listarMotoresPorMarca(Integer idMarca){
		List<Motor> motoresMarca = marcaService.getMotoresDaMarca(idMarca);
		ArrayList<MotorDTO> listaFiltrada = new ArrayList<MotorDTO>();
		motoresMarca.stream().forEach(e -> listaFiltrada.add(converterParaDTO(e)));
		return listaFiltrada;
		
	}
	
	private MotorDTO converterParaDTO(Motor motor) {
		MotorDTO motorDTO = new MotorDTO();
		motorDTO.setIdMotor(motor.getIdMotor());
		motorDTO.setCodigoMotor(motor.getCodigoMotor());
		motorDTO.setNomeMotor(motor.getNomeMotor());
		motorDTO.setCilindrada(motor.getCilindrada());
		motorDTO.setDescricaoMotor(motor.getDescricaoMotor());
		motorDTO.setFabricante(motor.getFabricante().getIdMarca());
		motorDTO.setNomeFabricante(motor.getFabricante().getNomeMarca());
		
		return motorDTO;
	}
	
}
