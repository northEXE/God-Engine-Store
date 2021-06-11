package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
	public void cadastrarMotor(Motor motor) {
		motorRepository.save(motor);
	}
	
	public List<Motor> getTodosOsMotores(){
		return motorRepository.findAll();
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
	
	public void addMotorListaMotoresModelo(Integer idModelo, Motor motor) {
		Modelo modelo = modeloService.buscarPorId(idModelo);
		modelo.getMotoresCompativeis().add(motor);
		
		modeloService.cadastrarModelo(modelo);
		motorRepository.save(motor);
	}
	
	public List<Motor> getMotoresDaMarca(Integer idMarca){
		Marca marca = marcaService.buscarPorId(idMarca);
		return marca.getMotores();
	}
}
