package br.com.godenginestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "Modelo")
@Data
@Builder
public class Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idModelo;

	@OneToOne
	private Marca marca;

	@Column(name = "nomeModelo")
	private String nomeModelo;

	@Column(name = "anoModelo")
	private String anosEmFabricacao;

	@Column(name = "descricaoModelo")
	private String descricaoModelo;

	@OneToOne
	private Motor motor;

	@Column(name = "isNacional")
	private String isNacional;

	@Column(name = "isEmLinha")
	private String isEmLinha;

}
