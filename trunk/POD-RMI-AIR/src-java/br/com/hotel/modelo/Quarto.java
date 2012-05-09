package br.com.hotel.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int num;
	private String andar;
	private String status;
	private Double preco;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	public Quarto() {
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
