package br.com.hotel.controle;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import br.com.hotel.modelo.Hotel;
import br.com.hotel.servico.IredeHoteleira;
import br.com.hotel.servico.Servico;

public class HotelControle {
	private static IredeHoteleira servico;
	public HotelControle() {
		super();
		servico = Servico.getServico();
	}
	public List<Hotel> getHoteis(){
		List<Hotel> hoteis = new ArrayList<Hotel>();
		try {
			hoteis = servico.getHoteis();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hoteis;
	}
	public Hotel adicionarHotel(Hotel hotel){
		servico = Servico.getServico();
		try {
			if(servico.adicionarHotel(hotel))
				return hotel;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Hotel buscarHotel(String codigo){
		try {
			return servico.buscarHotel(codigo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Hotel> buscarHotelNome(String nome){
		try {
			return servico.buscarHotelNome(nome);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Hotel alterarHotel(String codigo,Hotel hotel){
		try {
			return servico.alterarHotel(codigo,hotel);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean excluirHotel(Hotel hotel){
		try{
			return servico.excluirHotel(hotel);
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args){
		HotelControle hotel = new HotelControle();
		Hotel h = new Hotel();
		h.setCodigo("123");
		h.setGerente("Natan");
		h = hotel.adicionarHotel(h);
		System.out.println(h.getGerente());
		
	}
}
