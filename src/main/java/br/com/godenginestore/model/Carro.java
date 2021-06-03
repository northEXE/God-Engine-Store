package br.com.godenginestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Carro")
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

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public Marca getMarcaCarro() {
		return marcaCarro;
	}

	public void setMarcaCarro(Marca marcaCarro) {
		this.marcaCarro = marcaCarro;
	}

	public Modelo getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(Modelo modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public Integer getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(Integer anoCarro) {
		this.anoCarro = anoCarro;
	}

	public Motor getMotorizacao() {
		return motorizacao;
	}

	public void setMotorizacao(Motor motorizacao) {
		this.motorizacao = motorizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
