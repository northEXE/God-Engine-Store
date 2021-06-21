package br.com.godenginestore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.godenginestore.model.TipoPeca;

@Repository
@Transactional
public interface TipoPecaRepository extends JpaRepository<TipoPeca, Integer>{
	TipoPeca findByNomeTipoPeca(String nomeTipoPeca);
}
