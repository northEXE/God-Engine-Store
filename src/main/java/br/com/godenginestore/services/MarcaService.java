package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.repositories.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	MarcaRepository marcaRepository;

	@Autowired
	ModeloService modeloService;

	public void cadastrarMarca(Marca marca) {
		marcaRepository.save(marca);

	}

	public List<Marca> getTodasAsMarcas() {
		return marcaRepository.findAll();
	}

	public Marca buscarPorId(Integer idMarca) {
		return marcaRepository.getById(idMarca);
	}

	public void removerMarca(Integer idMarca) {
		marcaRepository.deleteById(idMarca);
	}

	public void addModeloNaMarca(Integer idMarca, Modelo modelo) {
		Marca marca = marcaRepository.getById(idMarca);
		modelo.setMarca(marca);
		marca.getModelos().add(modelo);

		marcaRepository.save(marca);
		modeloService.cadastrarModelo(modelo);
	}
	
	public void editarModeloNaMarca(Integer idMarca, Integer idModelo, Modelo modeloModificado) {
		Marca marca = marcaRepository.getById(idMarca);
		Modelo modelo = modeloService.buscarPorId(idModelo);
		marca.getModelos().remove(modelo);
		marcaRepository.save(marca);
		
		marca.getModelos().add(modeloModificado);
		
		marcaRepository.save(marca);
		modeloService.cadastrarModelo(modeloModificado);
	}

	public void deleteModeloDaMarca(Integer idMarca, Integer idModelo) {
		Marca marca = marcaRepository.getById(idMarca);
		Modelo modelo = modeloService.buscarPorId(idModelo);
		marca.getModelos().remove(modelo);
		modeloService.removerModelo(idModelo);

		marcaRepository.save(marca);
	}

	public List<Modelo> getModelosDaMarca(Integer idMarca) {
		Marca marca = marcaRepository.getById(idMarca);
		List<Modelo> modelos = marca.getModelos();

		return modelos;
	}

}
