package br.com.hotel.servico;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import br.com.hotel.dao.DAOArquivo;
import br.com.hotel.modelo.Hospedagem;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.Hotel;
import br.com.hotel.modelo.Quarto;
import br.com.hotel.modelo.Reserva;

public class SRedeHoteleria extends UnicastRemoteObject implements
		IredeHoteleira {


	private static final long serialVersionUID = 1L;
	private boolean bloqueado = false;
	
	private DAOArquivo arquivoDao;
	
	public SRedeHoteleria() throws RemoteException {
		arquivoDao = new DAOArquivo("banco.db");
	}

	public SRedeHoteleria(int arg0) throws RemoteException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SRedeHoteleria(int arg0, RMIClientSocketFactory arg1,
			RMIServerSocketFactory arg2) throws RemoteException {
		super(arg0, arg1, arg2);
	}

	@Override
	public synchronized String verificarReserva(String codigoHotel, Date dataInicio,
			Date dataFim) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public synchronized boolean efetuarHospedagem(Hotel hotel, Reserva reserva)
			throws Exception {
		if(!bloqueado){
			bloqueado = true;
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new Exception("Tentando acessar o banco...");
			}
			if(arquivoDao.efetuarHospedagem(hotel, reserva)){
				bloqueado = false;
				notifyAll();
				return true;
			}
				
		}
		return bloqueado;
	}

	@Override
	public synchronized String fecharHospedagem(String codigoHotel, String cpfHospede,
			boolean pago) throws RemoteException {
		return null;
	}

	@Override
	public synchronized List<Hospedagem> verificarDividas(String cpfHospede, boolean pago)
			throws RemoteException {
		return null;
	}
	/*
	 * Quartos
	 */
	@Override
	public synchronized Quarto adicionarQuarto(String codigoHotel, Quarto quarto)
			throws RemoteException {
		return arquivoDao.adicionarQuarto(codigoHotel, quarto);
	}
	@Override
	public synchronized Quarto alterarQuarto(String codigoHotel, String numeroQuarto,
			Quarto quarto) throws RemoteException {
		return arquivoDao.alterarQuarto(codigoHotel, numeroQuarto, quarto);
	}
	@Override
	public synchronized boolean excluirQuarto(String codigoHotel,Integer numeroQuarto) throws RemoteException {
		return arquivoDao.excluirQuarto(codigoHotel, numeroQuarto);
	}
	/*
	 * Hoteis
	 */	
	@Override
	public synchronized List<Hotel> getHoteis() throws RemoteException {
		return arquivoDao.getHoteis();
	}
	@Override
	public synchronized Hotel buscarHotel(String codigo) throws RemoteException {
		return arquivoDao.buscarHotel(codigo);
	}
	@Override
	public synchronized List<Hotel> buscarHotelNome(String nome) throws RemoteException {
		return arquivoDao.buscarHotelNome(nome);
	}
	@Override
	public synchronized boolean adicionarHotel(Hotel hotel) throws RemoteException {
		return arquivoDao.adicionarHotel(hotel);
	}
	@Override
	public synchronized Hotel alterarHotel(String codigo,Hotel hotel) throws RemoteException {
		return arquivoDao.alterarHotel(codigo,hotel);
	}

	@Override
	public  synchronized boolean excluirHotel(Hotel hotel) throws RemoteException {
		return arquivoDao.excluirHotel(hotel);
	}
	/*
	 * Reservas 
	 */
	@Override
	public synchronized boolean adicionarReserva(Hotel hotel, Quarto quarto, Reserva reserva)
			throws RemoteException {
		return arquivoDao.adicionarReserva(hotel, quarto, reserva);
	}
	
	/*
	 *hospedes 
	 */
	
	@Override
	public synchronized List<Hospede> getHospodes() throws RemoteException {
		return arquivoDao.getHospedes();
	}
	@Override
	public synchronized boolean adicionarHospede(Hospede hospede) throws RemoteException {
		// TODO Auto-generated method stub
		return arquivoDao.adicionarHospede(hospede);
	}
	@Override
	public synchronized List<Hospede> buscarHopedeNome(String nome) throws RemoteException {
		return arquivoDao.buscarHospedeNome(nome);
	}

	@Override
	public synchronized Hospede buscarHopedeCPF(String cpf) throws RemoteException {
		return arquivoDao.buscarHospedeCPF(cpf);
	}

	@Override
	public synchronized Hospede alterarHospede(String cpf, Hospede hospede)
			throws RemoteException {
		return arquivoDao.alterarHospede(cpf, hospede);
	}

	@Override
	public synchronized boolean excluirHospede(Hospede hospede) throws RemoteException {
		return arquivoDao.excluirHospede(hospede);
	}
}