package br.com.godenginestore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "Cliente")
@Data
@Builder
public class Cliente {
	@Id
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "nomeCliente")
	private String nomeCliente;
	
	@Column(name = "idadeCliente")
	private Integer idadeCliente;
	
	@Column(name = "telefoneCliente")
	private String telefoneCliente;
	
	@Column(name = "emailCliente")
	private String emailCliente;
	
	@Column(name = "dataNascimento")
	private String dataNascimento;
	
	@OneToMany
	private List<Carro> carrosCliente;


}
