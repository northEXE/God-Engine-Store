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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Peca")
@Data
@NoArgsConstructor
public class Peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPeca;

	@Column(name = "codigoPeca")
	private String codigoPeca;

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
	private List<Modelo> modelosAplicaveis;

	@OneToMany
	private List<Motor> motoresAplicaveis;

	@Column(name = "qtdEstoque")
	private Long qtdEstoque;

	@Column(name = "isEmFalta")
	private String isEmfalta;


}
