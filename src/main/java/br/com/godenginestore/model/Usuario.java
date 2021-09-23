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
@Table(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name = "nomeUsuario")
	private String nomeUsuario;
	
	@Column(name = "emailUsuario")
	private String emailUsuario;
	
	@Column(name = "senhaUsuario")
	private String senhaUsuario;
	
	@Column(name = "tipoUsuario")
	public String tipoUsuario;
	
}
