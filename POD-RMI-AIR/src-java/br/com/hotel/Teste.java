package br.com.hotel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import br.com.hotel.modelo.Hospede;
import br.com.hotel.servico.IredeHoteleira;

public class Teste {

	public Teste() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		IredeHoteleira servico = (IredeHoteleira) Naming.lookup( "rmi://localhost:2100/servico");
		
		//Hotel hotel = servico.buscarHotel("123");
		//System.out.println(hotel.getGerente());
		
		Hospede hospede = new Hospede();
		/*
		 * Cadastro de hospde teste
		 */
			try {
				while(true){
				List<Hospede> hs = servico.buscarHopedeNome(" ");
				System.out.println("Dormiu");
				Thread.sleep(1000);
				System.out.println("Acordou");
				for(Hospede h:hs){
					System.out.println(h.getNome());
				}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

}
