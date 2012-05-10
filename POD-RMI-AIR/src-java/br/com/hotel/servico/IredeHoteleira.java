package br.com.hotel.servico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import br.com.hotel.modelo.Hospedagem;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.Hotel;
import br.com.hotel.modelo.Quarto;
import br.com.hotel.modelo.Reserva;

public interface IredeHoteleira extends Remote {

	public Quarto cadastrarQuarto(String codigoHotel,String andar) throws RemoteException;
		
	public String verificarReserva(String codigoHotel, Date dataInicio, Date dataFim) throws RemoteException;
	
	public boolean efetuarReserva(Hospede hospede, Reserva reserva, String codigoHotel) throws RemoteException;
	
	public String efetuarHospedagem(String codigoHotel, String cpfHospede) throws RemoteException;
	
	public String fecharHospedagem(String codigoHotel, String cpfHospede, boolean pago) throws RemoteException;
	
	public List<Hospedagem> verificarDividas(String cpfHospede, boolean pago) throws RemoteException;
	
/*
 * Metodos para os Hospedes
 */
	public List<Hospede> getHospodes() throws RemoteException;
	public boolean adicionarHospede(Hospede hospede) throws RemoteException;
	public List<Hospede> buscarHopedeNome(String nome) throws RemoteException;
	public Hospede buscarHopedeCPF(String cpf) throws RemoteException;
	public Hospede alterarHospede(String cpf, Hospede hospede) throws RemoteException;
	public boolean excluirHospede(Hospede hospede) throws RemoteException;
/*
 * Metodos para hoteis
 */
	public List<Hotel> getHoteis() throws RemoteException;
	public Hotel buscarHotel(String codigo) throws RemoteException;
	public List<Hotel> buscarHotelNome(String nome) throws RemoteException;
	public boolean adicionarHotel(Hotel hotel) throws RemoteException;
	public Hotel alterarHotel(String codigo,Hotel hotel) throws RemoteException;
	public boolean excluirHotel(Hotel hotel) throws RemoteException;
/*
 * Metodo para Quarto
 */
	public Quarto alterarQuarto(String codigoHotel, String numeroQuarto, Quarto quarto) throws RemoteException;
	public boolean excluirQuarto(String codigoHotel,Integer numeroQuarto) throws RemoteException;
}
