package br.com.godenginestore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.godenginestore.model.Marca;

@Repository
@Transactional
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
	Marca findByNomeMarca(String nomeMarca);

}
