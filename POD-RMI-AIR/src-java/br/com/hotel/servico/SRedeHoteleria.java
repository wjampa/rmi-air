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
	public Quarto cadastrarQuarto(String codigoHotel, String andar)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verificarReserva(String codigoHotel, Date dataInicio,
			Date dataFim) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean efetuarReserva(Hospede hospede, Reserva reserva,
			String codigoHotel) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String efetuarHospedagem(String codigoHotel, String cpfHospede)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fecharHospedagem(String codigoHotel, String cpfHospede,
			boolean pago) throws RemoteException {
		return null;
	}

	@Override
	public List<Hospedagem> verificarDividas(String cpfHospede, boolean pago)
			throws RemoteException {
		return null;
	}
	/*
	 * Quartos
	 */
	@Override
	public Quarto alterarQuarto(String codigoHotel, String numeroQuarto,
			Quarto quarto) throws RemoteException {
		return arquivoDao.alterarQuarto(codigoHotel, numeroQuarto, quarto);
	}
	@Override
	public boolean excluirQuarto(String codigoHotel,Integer numeroQuarto) throws RemoteException {
		return arquivoDao.excluirQuarto(codigoHotel, numeroQuarto);
	}
	/*
	 * Hoteis
	 */	
	@Override
	public List<Hotel> getHoteis() throws RemoteException {
		return arquivoDao.getHoteis();
	}
	@Override
	public Hotel buscarHotel(String codigo) throws RemoteException {
		return arquivoDao.buscarHotel(codigo);
	}
	@Override
	public List<Hotel> buscarHotelNome(String nome) throws RemoteException {
		return arquivoDao.buscarHotelNome(nome);
	}
	@Override
	public boolean adicionarHotel(Hotel hotel) throws RemoteException {
		return arquivoDao.adicionarHotel(hotel);
	}
	@Override
	public Hotel alterarHotel(String codigo,Hotel hotel) throws RemoteException {
		return arquivoDao.alterarHotel(codigo,hotel);
	}

	@Override
	public boolean excluirHotel(Hotel hotel) throws RemoteException {
		return arquivoDao.excluirHotel(hotel);
	}

	
	/*
	 *hospedes 
	 */
	
	@Override
	public List<Hospede> getHospodes() throws RemoteException {
		return arquivoDao.getHospedes();
	}
	@Override
	public boolean adicionarHospede(Hospede hospede) throws RemoteException {
		// TODO Auto-generated method stub
		return arquivoDao.adicionarHospede(hospede);
	}
	@Override
	public List<Hospede> buscarHopedeNome(String nome) throws RemoteException {
		return arquivoDao.buscarHospedeNome(nome);
	}

	@Override
	public Hospede buscarHopedeCPF(String cpf) throws RemoteException {
		return arquivoDao.buscarHospedeCPF(cpf);
	}

	@Override
	public Hospede alterarHospede(String cpf, Hospede hospede)
			throws RemoteException {
		return arquivoDao.alterarHospede(cpf, hospede);
	}

	@Override
	public boolean excluirHospede(Hospede hospede) throws RemoteException {
		return arquivoDao.excluirHospede(hospede);
	}







}
