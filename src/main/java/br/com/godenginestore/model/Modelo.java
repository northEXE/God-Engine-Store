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
	private Integer anoModelo;
	
	@Column(name = "descricaoModelo")
	private String descricaoModelo;
	
	@OneToOne
	private Motor motor;
	
	@OneToMany
	private List<Motor> motoresCompativeis;
	
	@Column(name = "isNacional")
	private Boolean isNacional;
	
	@Column(name="isEmLinha")
	private Boolean isEmLinha;
	
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

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
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

	public List<Motor> getMotoresCompativeis() {
		return motoresCompativeis;
	}

	public void setMotoresCompativeis(List<Motor> motoresCompativeis) {
		this.motoresCompativeis = motoresCompativeis;
	}

	public Boolean getIsNacional() {
		return isNacional;
	}

	public void setIsNacional(Boolean isNacional) {
		this.isNacional = isNacional;
	}

	public Boolean getIsEmLinha() {
		return isEmLinha;
	}

	public void setIsEmLinha(Boolean isEmLinha) {
		this.isEmLinha = isEmLinha;
	}

}
