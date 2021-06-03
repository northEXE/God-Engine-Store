package br.com.godenginestore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.godenginestore.model.Carro;
import br.com.godenginestore.model.Modelo;

@Repository
@Transactional
public interface CarroRepository extends JpaRepository<Carro, Integer> {
	Carro findByModeloCarro(Modelo modeloCarro);
}
