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
@Table(name = "Peca")
public class Peca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPeca;
	
	@OneToOne
	private TipoPeca tipoPeca;
	
	@Column(name = "marcaPeca")
	private String marcaPeca;
	
	@Column(name = "modeloPeca")
	private String modeloPeca;
	
	@Column(name = "precoPeca")
	private Double precoPeca;
	
	@Column(name = "descricaoPeca")
	private String descricaoPeca;
	
	@OneToMany
	private List<Marca> marcasAplicaveis;
	
	@OneToMany
	private List<Modelo> modelosAplicaveis;
	
	@OneToMany
	private List<Motor> motoresAplicaveis;
	
	@Column(name = "qtdEstoque")
	private Long qtdEstoque;
	
	@Column(name = "isEmFalta")
	private String isEmfalta;

	public Integer getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(Integer idPeca) {
		this.idPeca = idPeca;
	}

	public TipoPeca getTipoPeca() {
		return tipoPeca;
	}

	public void setTipoPeca(TipoPeca tipoPeca) {
		this.tipoPeca = tipoPeca;
	}

	public String getMarcaPeca() {
		return marcaPeca;
	}

	public void setMarcaPeca(String marcaPeca) {
		this.marcaPeca = marcaPeca;
	}

	public String getModeloPeca() {
		return modeloPeca;
	}

	public void setModeloPeca(String modeloPeca) {
		this.modeloPeca = modeloPeca;
	}

	public Double getPrecoPeca() {
		return precoPeca;
	}

	public void setPrecoPeca(Double precoPeca) {
		this.precoPeca = precoPeca;
	}

	public String getDescricaoPeca() {
		return descricaoPeca;
	}

	public void setDescricaoPeca(String descricaoPeca) {
		this.descricaoPeca = descricaoPeca;
	}

	public List<Marca> getMarcasAplicaveis() {
		return marcasAplicaveis;
	}

	public void setMarcasAplicaveis(List<Marca> marcasAplicaveis) {
		this.marcasAplicaveis = marcasAplicaveis;
	}

	public List<Modelo> getModelosAplicaveis() {
		return modelosAplicaveis;
	}

	public void setModelosAplicaveis(List<Modelo> modelosAplicaveis) {
		this.modelosAplicaveis = modelosAplicaveis;
	}

	public List<Motor> getMotoresAplicaveis() {
		return motoresAplicaveis;
	}

	public void setMotoresAplicaveis(List<Motor> motoresAplicaveis) {
		this.motoresAplicaveis = motoresAplicaveis;
	}

	public Long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getIsEmfalta() {
		return isEmfalta;
	}

	public void setIsEmfalta(String isEmfalta) {
		this.isEmfalta = isEmfalta;
	}

}
