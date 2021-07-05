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
@Table(name = "Motor")
@Data
@NoArgsConstructor
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

}
