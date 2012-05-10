package br.com.hotel.servico;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.hotel.util.Configuracao;



public abstract class Servico {

	private static IredeHoteleira servico;
	
	public static IredeHoteleira getServico() {
		if(servico == null)
			try {
				Registry registry = LocateRegistry.getRegistry(Configuracao.ipServidor, 2100);
				servico = (IredeHoteleira)Naming.lookup( Configuracao.ipServidor+":"+Configuracao.porta+"/"+Configuracao.nomeServico);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return servico;
	}
}
