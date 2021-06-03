package br.com.godenginestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoPeca")
public class TipoPeca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoPeca;
	
	@Column(name = "tipoPeca")
	private String tipoPeca;

	public void setIdTipoPeca(Integer idTipoPeca) {
		this.idTipoPeca = idTipoPeca;
	}

	public void setTipoPeca(String tipoPeca) {
		this.tipoPeca = tipoPeca;
	}

	public Integer getIdTipoPeca() {
		return idTipoPeca;
	}

	public String getTipoPeca() {
		return tipoPeca;
	}
}
