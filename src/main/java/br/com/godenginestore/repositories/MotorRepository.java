package br.com.godenginestore.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.godenginestore.model.Motor;

@Repository
@Transactional
public interface MotorRepository extends JpaRepository<Motor, Integer> {
	Motor findByCodigoMotor(String codigoMotor);
	Motor findByNomeMotor(String nomeMotor);
}
