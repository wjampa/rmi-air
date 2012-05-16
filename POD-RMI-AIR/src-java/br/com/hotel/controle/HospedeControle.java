package br.com.hotel.controle;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import br.com.hotel.modelo.Hospede;
import br.com.hotel.rmi.cliente.Servico;
import br.com.hotel.servico.IredeHoteleira;

public class HospedeControle {
	private static IredeHoteleira servico;

	public HospedeControle() {
		super();
		servico = Servico.getServico();
	}
	
	public List<Hospede> getHospedes(){
		List<Hospede> hospedes = new ArrayList<Hospede>();
		
		try {
			hospedes = servico.getHospodes();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hospedes; 
	}
	public Hospede adicionarHospede(Hospede hospede){
		//servico = Servico.getServico();
		try {
			if(servico.adicionarHospede(hospede))
				return hospede;
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		return null;
		
	}
	public List<Hospede> buscarHospedeNome(String nome){
		//servico = Servico.getServico();
		List<Hospede> hospedes = new ArrayList<Hospede>();
		try {
			hospedes.addAll(servico.buscarHopedeNome(nome));
			return hospedes;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Hospede buscarHospedeCPF(String cpf){
		Hospede hospede = new Hospede();
		try {
			hospede = servico.buscarHopedeCPF(cpf);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hospede;
	}
	public Hospede alterarHospede(String cpf,Hospede hospede){
		try {
			return servico.alterarHospede(cpf, hospede);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean excluirHospede(Hospede hospede){
		try {
			return servico.excluirHospede(hospede);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args){
		HospedeControle hc = new HospedeControle();
		List<Hospede> hospedes = new ArrayList<Hospede>();
		hospedes = hc.buscarHospedeNome("a");
		
		System.out.println("fim" + hospedes.get(0).getNome());
	}
}
