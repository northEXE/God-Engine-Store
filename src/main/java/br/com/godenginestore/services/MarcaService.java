package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.repositories.MarcaRepository;
import br.com.godenginestore.repositories.ModeloRepository;

@Service
public class MarcaService {

	@Autowired
	MarcaRepository marcaRepository;

	@Autowired
	ModeloRepository modeloRepository;

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
		modeloRepository.save(modelo);
	}

	public void deleteModeloDaMarca(Integer idMarca, Integer idModelo) {
		Marca marca = marcaRepository.getById(idMarca);
		Modelo modelo = modeloRepository.getById(idModelo);
		marca.getModelos().remove(modelo);
		modeloRepository.deleteById(idModelo);

		marcaRepository.save(marca);
	}

	public List<Modelo> getModelosDaMarca(Integer idMarca) {
		Marca marca = marcaRepository.getById(idMarca);
		List<Modelo> modelos = marca.getModelos();

		return modelos;
	}

}
