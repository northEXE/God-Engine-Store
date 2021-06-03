package br.com.godenginestore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.godenginestore.model.Modelo;

@Repository
@Transactional
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
	Modelo findByNomeModelo(String nomeModelo);
}
