package br.com.godenginestore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.godenginestore.model.Peca;
import br.com.godenginestore.model.TipoPeca;

@Repository
@Transactional
public interface PecaRepository extends JpaRepository<Peca, Integer>{
	Peca findByTipoPeca(TipoPeca tipoPeca);
	Peca findByMarcaPeca(String marcaPeca);
	Peca findByModeloPeca(String ModeloPeca);
}
