package br.com.hotel.controle;

import java.rmi.RemoteException;

import br.com.hotel.modelo.Quarto;
import br.com.hotel.rmi.cliente.Servico;
import br.com.hotel.servico.IredeHoteleira;

public class QuartoControle {

	private static IredeHoteleira servico;
	public QuartoControle() {
		super();
		servico = Servico.getServico();
	}
	public Quarto adicionarQuarto(String  codigoHotel, Quarto quarto){
		try {
			return servico.adicionarQuarto(codigoHotel, quarto);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Quarto alterarQuarto(String  codigoHotel, String numeroQuarto,Quarto quarto){
		try {
			return servico.alterarQuarto(codigoHotel, numeroQuarto, quarto);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean excluirQuarto(String codigoHotel,Integer numeroQuarto){
		try {
			return servico.excluirQuarto(codigoHotel, numeroQuarto);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
