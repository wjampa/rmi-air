package br.com.hotel.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.Hotel;
import br.com.hotel.modelo.Quarto;
import br.com.hotel.modelo.RedeHoteleira;
import br.com.hotel.modelo.Reserva;

public class DAOArquivo {
	
	private RedeHoteleira redeHoteleira;
	private String banco;
	
	public DAOArquivo(String arquivo) {
		this.banco = arquivo;
		try{
			if(new File(banco).exists()){
				FileInputStream fis = new FileInputStream(banco);
				ObjectInputStream ois = new ObjectInputStream(fis);
				redeHoteleira = (RedeHoteleira)ois.readObject();
				ois.close();
				fis.close();
			}else{
				FileOutputStream fos = new FileOutputStream(banco);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				redeHoteleira = new RedeHoteleira();
				oos.writeObject(redeHoteleira);
				oos.close();
				fos.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/*
	 * Quartos
	 */
	public Quarto adicionarQuarto(String codigoHotel,Quarto quarto){
		for(Hotel h : redeHoteleira.getHoteis()){
			if(h.getCodigo().equals(codigoHotel)){
				h.getQuartos().add(quarto);
				if(atualizarArquivo())
					return quarto;
				else
					return null;
			}
		}
		return null;
	}
	public Quarto alterarQuarto(String codigoHotel,String numeroQuarto,Quarto quarto){
		for(Hotel h : redeHoteleira.getHoteis()){
			if(h.getCodigo().equals(codigoHotel)){
				
				for(Quarto q:h.getQuartos()){
					if(q.getNum() == Integer.parseInt(numeroQuarto)){
						h.getQuartos().remove(q);
						h.getQuartos().add(quarto);
						if(atualizarArquivo())
							return quarto;
						else
							return null;
					}
					
				}
			}
		}
		return null;
	}
	public boolean excluirQuarto(String codigoHotel, Integer numeroQuarto){
		for(Hotel h : redeHoteleira.getHoteis()){
			if(h.getCodigo().equals(codigoHotel)){
				
				for(Quarto q:h.getQuartos()){
					if(q.getNum() == numeroQuarto){
						h.getQuartos().remove(q);
						if(atualizarArquivo())
							return true;
						else
							return false;
					}
					
				}
			}
		}
		return false;
	}
	/*
	 * Hoteis
	 */
	public boolean adicionarHotel(Hotel hotel){
		for (Hotel h : redeHoteleira.getHoteis()) {
			if(h.getCodigo().equals(hotel.getCodigo()))
				return false;
		}
		redeHoteleira.getHoteis().add(hotel);
		return atualizarArquivo();
	}

	public Hotel buscarHotel(String codigoHotel) {
		for (Hotel h : redeHoteleira.getHoteis()) {
			if(h.getCodigo().equals(codigoHotel))
				return h;
		}
		return null;
	}
	public List<Hotel> buscarHotelNome(String nome){
		List<Hotel> hoteis = new ArrayList<Hotel>();
		int contem = 0;
		for(Hotel h : redeHoteleira.getHoteis()){
			contem = h.getNome().indexOf(nome);
			if(contem != -1){
				hoteis.add(h);
			}
		}
		return hoteis;
	}
	public List<Hotel> getHoteis(){
		return redeHoteleira.getHoteis();
	}
	public Hotel alterarHotel(String codigo,Hotel hotel){
		for(Hotel h : redeHoteleira.getHoteis()){
			if(h.getCodigo().equals(codigo)){
				redeHoteleira.getHoteis().remove(h);
				redeHoteleira.getHoteis().add(hotel);
				if(atualizarArquivo())
					return hotel;
				else
					return null;
			}
		}
		return null;
	}
	public boolean excluirHotel(Hotel hotel){
		for(Hotel h : redeHoteleira.getHoteis()){
			if(h.getCodigo().equals(hotel.getCodigo())){
				redeHoteleira.getHoteis().remove(h);
				if(atualizarArquivo())
					return true;
			}
		}
		return false;
	}
	
	/*
	 * Hospedes
	 */
	public boolean adicionarHospede(Hospede hospede) {
		redeHoteleira.getHospedes().add(hospede);
		return atualizarArquivo();
	}
	public Hospede buscarHospedeCPF(String cpf){
		for(Hospede h : redeHoteleira.getHospedes()){
			if(h.getCpf().equals(cpf)){
				return h;
			}
		}
		return null;
	}
	public List<Hospede> buscarHospedeNome(String nome){
		List<Hospede> hospedes = new ArrayList<Hospede>();
		int contem = 0;
		for(Hospede h : redeHoteleira.getHospedes()){
			contem = h.getNome().indexOf(nome);
			if(contem != -1){
				hospedes.add(h);
			}
		}
		return hospedes;
	}
	
	public List<Hospede> getHospedes(){
		List<Hospede> hospedes = new ArrayList<Hospede>();
		for(Hospede h:redeHoteleira.getHospedes()){
			hospedes.add(h);
		}
		return hospedes;
	}
	public Hospede alterarHospede(String cpf,Hospede hospede){
		
		for(Hospede h : redeHoteleira.getHospedes()){
			if(h.getCpf().equals(cpf)){
				redeHoteleira.getHospedes().remove(h);
				redeHoteleira.getHospedes().add(hospede);
				if(atualizarArquivo())
					return hospede;
				else
					return null;
			}
		}
		return null;
	}
	public boolean excluirHospede(Hospede hospede){
		for(Hospede h : redeHoteleira.getHospedes()){
			if(h.getCpf().equals(hospede.getCpf())){
				redeHoteleira.getHospedes().remove(h);
				if(atualizarArquivo())
					return true;
			}
		}
		return false;
	}
	/*
	 * Reservas
	 */
	public boolean adicionarReserva(Hotel hotel, Quarto quarto, Reserva reserva){
		
		for(Hotel h:redeHoteleira.getHoteis()){
			if(h.getCodigo().equals(hotel.getCodigo())){
				for(Quarto q:h.getQuartos()){
					if(q.getNum() == quarto.getNum()){
						q.getReservas().add(reserva);
						h.getReservas().add(reserva);
						return atualizarArquivo();
					}
				}
				
			}
		}
		return false;
	}
	public boolean atualizarArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream(this.banco);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(redeHoteleira);
			oos.close();
			fos.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
