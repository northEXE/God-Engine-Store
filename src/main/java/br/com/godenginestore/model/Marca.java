package br.com.godenginestore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Marca")
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
	
	@Column(name = "isEmAtividade")
	private String isEmAtividade;

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Motor> getMotores() {
		return motores;
	}

	public void setMotores(List<Motor> motores) {
		this.motores = motores;
	}

	public String getIsEmAtividade() {
		return isEmAtividade;
	}

	public void setIsEmAtividade(String isEmAtividade) {
		this.isEmAtividade = isEmAtividade;
	}

}
