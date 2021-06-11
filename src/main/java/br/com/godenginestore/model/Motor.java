package br.com.godenginestore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Motor")
public class Motor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMotor;
	
	@Column(name = "codigoMotor")
	private String codigoMotor;
	
	@Column(name = "nomeMotor")
	private String nomeMotor;
	
	@OneToOne
	private Marca fabricante;
	
	@Column(name = "cilindrada")
	private Double cilindrada;
	
	@Column(name = "descricaoMotor")
	private String descricaoMotor;
	
	@OneToMany
	private List<Modelo> modelosAplicados;
	
	public Integer getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(Integer idMotor) {
		this.idMotor = idMotor;
	}

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
	

	public String getDescricaoMotor() {
		return descricaoMotor;
	}

	public void setDescricaoMotor(String descricaoMotor) {
		this.descricaoMotor = descricaoMotor;
	}

	public List<Modelo> getModelosAplicados() {
		return modelosAplicados;
	}

	public void setModelosAplicados(List<Modelo> modelosAplicados) {
		this.modelosAplicados = modelosAplicados;
	}

}
