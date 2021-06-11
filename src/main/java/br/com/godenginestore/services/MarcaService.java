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
	
	public Marca buscarPorNome(String nomeMarca) {
		return marcaRepository.findByNomeMarca(nomeMarca);
	}

	public void removerMarca(Integer idMarca) {
		marcaRepository.deleteById(idMarca);
	}

	public List<Modelo> getModelosDaMarca(Integer idMarca) {
		Marca marca = marcaRepository.getById(idMarca);
		List<Modelo> modelos = marca.getModelos();

		return modelos;
	}
	

}
