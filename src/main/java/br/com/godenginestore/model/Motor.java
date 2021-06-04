package br.com.godenginestore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Motor")
public class Motor {
	
	@Id
	private String codigoMotor;
	
	@Column(name = "nomeMotor")
	private String nomeMotor;
	
	@OneToOne
	private Marca fabricante;
	
	@Column(name = "cilindrada")
	private Double cilindrada;
	
	@Column(name = "isNacional")
	private Boolean isNacional;
	
	@Column(name = "isEmProducao")
	private String isEmProducao;
	
	@OneToMany
	private List<Modelo> modelosAplicados;

	public String getCodigoMotor() {
		return codigoMotor;
	}

	public void setCodigoMotor(String codigoMotor) {
		this.codigoMotor = codigoMotor;
	}

	public String getNomeMotor() {
		return nomeMotor;
	}

	public void setNomeMotor(String nomeMotor) {
		this.nomeMotor = nomeMotor;
	}

	public Marca getFabricante() {
		return fabricante;
	}

	public void setFabricante(Marca fabricante) {
		this.fabricante = fabricante;
	}

	public Double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Double cilindrada) {
		this.cilindrada = cilindrada;
	}

	public Boolean getIsNacional() {
		return isNacional;
	}

	public void setIsNacional(Boolean isNacional) {
		this.isNacional = isNacional;
	}

	public String getIsEmProducao() {
		return isEmProducao;
	}

	public void setIsEmProducao(String isEmProducao) {
		this.isEmProducao = isEmProducao;
	}

	public List<Modelo> getModelosAplicados() {
		return modelosAplicados;
	}

	public void setModelosAplicados(List<Modelo> modelosAplicados) {
		this.modelosAplicados = modelosAplicados;
	}

}
