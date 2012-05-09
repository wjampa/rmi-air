package br.com.hotel.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RedeHoteleira implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Hotel> hoteis = new ArrayList<Hotel>();
	private List<Hospede> hospedes = new ArrayList<Hospede>(); 
	public RedeHoteleira() {
		// TODO Auto-generated constructor stub
	}
	public List<Hotel> getHoteis() {
		return hoteis;
	}
	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}
	public List<Hospede> getHospedes() {
		return hospedes;
	}
	public void setHospedes(List<Hospede> hospedes) {
		this.hospedes = hospedes;
	}

}
