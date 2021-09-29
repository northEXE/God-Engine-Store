package br.com.godenginestore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.dto.ModeloDTO;
import br.com.godenginestore.dto.MotorDTO;
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

	public Modelo cadastrarModelo(Modelo modelo) {
		return modeloRepository.save(modelo);
	}

	public List<ModeloDTO> getTodosOsModelos() {
		List<Modelo> modelos = modeloRepository.findAll();
		ArrayList<ModeloDTO> listaFiltrada = new ArrayList<ModeloDTO>();
		modelos.stream().forEach(e -> listaFiltrada.add(converterParaDTO(e)));
		return listaFiltrada;
	}

	public Modelo buscarPorId(Integer idModelo) {
		return modeloRepository.getById(idModelo);
	}
	
	public Optional<Modelo> buscarPorIdOptional(Integer idModelo){
		return modeloRepository.findById(idModelo);
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
	
	public Modelo editarModeloNaMarca(Integer idMarca, Integer idModelo, Modelo modeloModificado) {
		Marca marca = marcaService.buscarPorId(idMarca);
		Modelo modelo = modeloRepository.getById(idModelo);
		marca.getModelos().remove(modelo);
		marcaService.cadastrarMarca(marca);
		
		marca.getModelos().add(modeloModificado);
		
		marcaService.cadastrarMarca(marca);
		return modeloRepository.save(modeloModificado);
	}
	
	public void deleteModeloDaMarca(Integer idMarca, Integer idModelo) {
		Marca marca = marcaService.buscarPorId(idMarca);
		Modelo modelo = modeloRepository.getById(idModelo);
		marca.getModelos().remove(modelo);
		modeloRepository.deleteById(idModelo);

		marcaService.cadastrarMarca(marca);
	}
	
	public List<MotorDTO> listarMotoresParaCadastroModelo(){
		return motorService.listarTodosOsMotores();
	}
	
	private ModeloDTO converterParaDTO(Modelo modelo) {
		ModeloDTO modeloDTO = new ModeloDTO();
		modeloDTO.setIdModelo(modelo.getIdModelo());
		modeloDTO.setMarca(modelo.getMarca().getIdMarca());
		modeloDTO.setNomeMarca(modelo.getMarca().getNomeMarca());
		modeloDTO.setNomeModelo(modelo.getNomeModelo());
		modeloDTO.setAnosEmFabricacao(modelo.getAnosEmFabricacao());
		modeloDTO.setDescricaoModelo(modelo.getDescricaoModelo());
		modeloDTO.setMotor(modelo.getMotor().getIdMotor());
		modeloDTO.setNomeMotor(modelo.getMotor().getNomeMotor());
		
		return modeloDTO;
	}
	
	
}
