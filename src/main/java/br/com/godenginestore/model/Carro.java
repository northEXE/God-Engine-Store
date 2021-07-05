package br.com.godenginestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "Carro")
@Data
@NoArgsConstructor
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCarro;

	@OneToOne
	private Marca marcaCarro;

	@OneToOne
	private Modelo modeloCarro;

	@Column(name = "anoCarro")
	private Integer anoCarro;

	@OneToOne
	private Motor motorizacao;

	@Column(name = "descricao")
	private String descricao;

}
