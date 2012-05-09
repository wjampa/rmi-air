package br.com.hotel.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hospede implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String telefone;
	private String endereco;
	private String cpf;
	private String numero;
	private List<Reserva> reservas= new ArrayList<Reserva>();
	
	public Hospede() {
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	

}
