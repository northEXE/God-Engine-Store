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

	public Boolean cadastrarMarca(Marca marca) {
		List<Marca> marcas = marcaRepository.findAll();
		for(Marca m : marcas) {
			if(marca.getNomeMarca().toUpperCase().equals(m.getNomeMarca().toUpperCase()))
				return false;
		}
		marcaRepository.save(marca);
		return true;	
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
