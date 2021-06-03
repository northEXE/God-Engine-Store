package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	MarcaRepository marcaRepository;
	
	public void cadastrarMarca(Marca marca) {
		marcaRepository.save(marca);
		
	}
	
	public List<Marca> getTodasMarcas(){
		return marcaRepository.findAll();
	}
	
	public Marca buscarPorId(Integer idMarca) {
		return marcaRepository.getById(idMarca);
	}
	
	public void removerMarca(Integer idMarca) {
		marcaRepository.deleteById(idMarca);
	}
	
}
