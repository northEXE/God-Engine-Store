package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.model.Motor;
import br.com.godenginestore.repositories.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	ModeloRepository modeloRepository;
	
	@Autowired
	MarcaService marcaService;
	
	@Autowired
	MotorService motorService;

	public void cadastrarModelo(Modelo modelo) {
		modeloRepository.save(modelo);
	}

	public List<Modelo> getTodosOsModelos() {
		return modeloRepository.findAll();
	}

	public Modelo buscarPorId(Integer idModelo) {
		return modeloRepository.getById(idModelo);
	}

	public void removerModelo(Integer idModelo) {
		modeloRepository.deleteById(idModelo);
	}
	
	
	public void addModeloNaMarca(Integer idMarca, Modelo modelo) {
		Marca marca = marcaService.buscarPorId(idMarca);
		modelo.setMarca(marca);
		marca.getModelos().add(modelo);

		marcaService.cadastrarMarca(marca);
		modeloRepository.save(modelo);
	}
	
	public void addMotorDoModelo(Integer idMotor, Modelo modelo) {
		Motor motor = motorService.buscarMotorPorId(idMotor);
		modelo.setMotor(motor);
		
		motorService.cadastrarMotor(motor);
		modeloRepository.save(modelo);
	}
	
	public void editarModeloNaMarca(Integer idMarca, Integer idModelo, Modelo modeloModificado) {
		Marca marca = marcaService.buscarPorId(idMarca);
		Modelo modelo = modeloRepository.getById(idModelo);
		marca.getModelos().remove(modelo);
		marcaService.cadastrarMarca(marca);
		
		marca.getModelos().add(modeloModificado);
		
		marcaService.cadastrarMarca(marca);
		modeloRepository.save(modeloModificado);
	}
	
	public void deleteModeloDaMarca(Integer idMarca, Integer idModelo) {
		Marca marca = marcaService.buscarPorId(idMarca);
		Modelo modelo = modeloRepository.getById(idModelo);
		marca.getModelos().remove(modelo);
		modeloRepository.deleteById(idModelo);

		marcaService.cadastrarMarca(marca);
	}
	
	public List<Motor> listarMotoresParaCadastroModelo(){
		return motorService.getTodosOsMotores();
	}
	
	
}
