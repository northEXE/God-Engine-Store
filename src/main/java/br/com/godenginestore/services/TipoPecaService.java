package br.com.godenginestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.model.TipoPeca;
import br.com.godenginestore.repositories.TipoPecaRepository;

@Service
public class TipoPecaService {
	
	@Autowired
	TipoPecaRepository tipoPecaRepository;
	
	public void cadastrarTipoDePeca(TipoPeca tipoPeca) {
		tipoPecaRepository.save(tipoPeca);
	}
	
	public TipoPeca buscarTipoPorId(Integer idTipoPeca) {
		return tipoPecaRepository.getById(idTipoPeca);
	}
	
	public List<TipoPeca> listarTodosOsTipos(){
		return tipoPecaRepository.findAll();
	}
	
}
