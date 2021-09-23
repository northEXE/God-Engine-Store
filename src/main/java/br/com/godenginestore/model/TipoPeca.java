package br.com.godenginestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TipoPeca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoPeca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoPeca;
	
	@Column(name = "nomeTipoPeca")
	private String nomeTipoPeca;

	public void setIdTipoPeca(Integer idTipoPeca) {
		this.idTipoPeca = idTipoPeca;
	}

	public void setNomeTipoPeca(String nomeTipoPeca) {
		this.nomeTipoPeca = nomeTipoPeca;
	}

	public Integer getIdTipoPeca() {
		return idTipoPeca;
	}

	public String getNomeTipoPeca() {
		return nomeTipoPeca;
	}
}
