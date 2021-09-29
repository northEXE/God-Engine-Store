package br.com.godenginestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Modelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idModelo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	@JsonIgnore
	private String isNacional;

	@Column(name = "isEmLinha")
	@JsonIgnore
	private String isEmLinha;

}
