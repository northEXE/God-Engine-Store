package br.com.godenginestore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.godenginestore.model.Peca;
import br.com.godenginestore.model.TipoPeca;
import br.com.godenginestore.repositories.PecaRepository;

@Service
public class PecaService {
	
	@Autowired
	PecaRepository pecaRepository;
	
	@Autowired
	TipoPecaService tipoPecaService;
	
	public void cadastrarPeca(Peca peca) {
		pecaRepository.save(peca);
	}
	
	public Peca buscarPorId(Integer idPeca) {
		return pecaRepository.getById(idPeca);
	}
	
	public List<Peca> buscarPorTipo(Integer idTipoPeca){
		TipoPeca tipoPeca = tipoPecaService.buscarTipoPorId(idTipoPeca);
		List<Peca> pecas = pecaRepository.findAll();
		ArrayList<Peca> pecasPorTipo = new ArrayList<Peca>();
		for(Peca peca : pecas) {
			if(peca.getTipoPeca().equals(tipoPeca)) {
				pecasPorTipo.add(peca);
			}
		}
		return pecasPorTipo;
	}
	
	public List<Peca> listarTodasAsPecas(){
		return pecaRepository.findAll();
	}
	
	public void apagarPeca(Integer idPeca) {
		Peca peca = pecaRepository.getById(idPeca);
		pecaRepository.delete(peca);
	}
	
	public void inserirTipoPeca(Peca peca, Integer idTipoPeca) {
		TipoPeca tipoPeca = tipoPecaService.buscarTipoPorId(idTipoPeca);
		
		peca.setTipoPeca(tipoPeca);
		
		tipoPecaService.cadastrarTipoDePeca(tipoPeca);
		pecaRepository.save(peca);
	}
}


