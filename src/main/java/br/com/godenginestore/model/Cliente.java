package br.com.godenginestore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getIdadeCliente() {
		return idadeCliente;
	}

	public void setIdadeCliente(Integer idadeCliente) {
		this.idadeCliente = idadeCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Carro> getCarrosCliente() {
		return carrosCliente;
	}

	public void setCarrosCliente(List<Carro> carrosCliente) {
		this.carrosCliente = carrosCliente;
	}

}
