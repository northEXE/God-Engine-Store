package br.com.godenginestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Modelo")
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

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public String getAnosEmFabricacao() {
		return anosEmFabricacao;
	}

	public void setAnosEmFabricacao(String anosEmFabricacao) {
		this.anosEmFabricacao = anosEmFabricacao;
	}

	public String getDescricaoModelo() {
		return descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public String getIsNacional() {
		return isNacional;
	}

	public void setIsNacional(String isNacional) {
		this.isNacional = isNacional;
	}

	public String getIsEmLinha() {
		return isEmLinha;
	}

	public void setIsEmLinha(String isEmLinha) {
		this.isEmLinha = isEmLinha;
	}

}
