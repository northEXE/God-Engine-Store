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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Motor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMotor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Motor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMotor;
	
	@Column(name = "codigoMotor")
	private String codigoMotor;
	
	@Column(name = "nomeMotor")
	private String nomeMotor;
	
	@OneToOne
	@JsonIgnore
	private Marca fabricante;
	
	@Column(name = "cilindrada")
	private Double cilindrada;
	
	@Column(name = "descricaoMotor")
	private String descricaoMotor;
	
	@OneToMany
	@JsonIgnore
	private List<Modelo> modelosAplicados;

}
