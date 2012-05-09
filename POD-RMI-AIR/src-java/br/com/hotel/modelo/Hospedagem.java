package br.com.hotel.modelo;

import java.io.Serializable;
import java.util.Date;

public class Hospedagem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date dataInicioHospedagem;
	private Date dataFimHospedagem;
	private boolean pago;
	public Hospedagem() {
		// TODO Auto-generated constructor stub
	}
	public Date getDataInicioHospedagem() {
		return dataInicioHospedagem;
	}
	public void setDataInicioHospedagem(Date dataInicioHospedagem) {
		this.dataInicioHospedagem = dataInicioHospedagem;
	}
	public Date getDataFimHospedagem() {
		return dataFimHospedagem;
	}
	public void setDataFimHospedagem(Date dataFimHospedagem) {
		this.dataFimHospedagem = dataFimHospedagem;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}

}
