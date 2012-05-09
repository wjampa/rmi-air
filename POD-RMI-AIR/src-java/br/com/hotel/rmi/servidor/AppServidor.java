package br.com.hotel.rmi.servidor;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.hotel.servico.SRedeHoteleria;


public class AppServidor {


	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(2100);
			registry.rebind("servico", new SRedeHoteleria());
			System.out.println("Servidor ativo");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
