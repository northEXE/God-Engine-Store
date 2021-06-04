package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.repositories.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	ModeloRepository modeloRepository;

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
}
