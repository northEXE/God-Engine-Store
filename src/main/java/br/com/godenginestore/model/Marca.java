package br.com.godenginestore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Marca")
@Data
@NoArgsConstructor
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMarca;
	
	@Column(name = "nomeMarca")
	private String nomeMarca;
	
	@OneToMany
	private List<Modelo> modelos;
	
	@OneToMany
	private List<Motor> motores;
	

	}
