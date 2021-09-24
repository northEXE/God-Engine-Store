package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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

	public Marca cadastrarMarca(Marca marca) {
		List<Marca> marcas = marcaRepository.findAll();
		for(Marca m : marcas) {
			if(marca.getNomeMarca().toUpperCase().equals(m.getNomeMarca().toUpperCase()))
				return null;
		}
		return marcaRepository.save(marca);
	}

	public List<Marca> getTodasAsMarcas() {
		return marcaRepository.findAll();
	}

	public Marca buscarPorId(Integer idMarca) {
		return marcaRepository.getById(idMarca);
	}
	
	public List<Marca> buscarPorNome(Marca marcaFiltro) {
		Example<Marca> example = Example.of(marcaFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return marcaRepository.findAll(example);
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
