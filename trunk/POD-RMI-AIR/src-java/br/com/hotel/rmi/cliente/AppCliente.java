package br.com.hotel.rmi.cliente;
import java.rmi.Naming;
import java.util.List;

import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.Hotel;
import br.com.hotel.servico.IredeHoteleira;


public class AppCliente {

	public static void main(String[] args) {
		
		try {
			//Registry registry = LocateRegistry.getRegistry(Configuracao.ipServidor, 2100);
			IredeHoteleira servico = (IredeHoteleira) Naming.lookup( "rmi://localhost:2100/servico");
	
			//Hotel hotel = servico.buscarHotel("123");
			//System.out.println(hotel.getGerente());
			
			Hospede hospede = new Hospede();
			/*
			 * Cadastro de hospde teste
			 */
			while(true){
				System.out.println("já");
			List<Hospede> hs = servico.buscarHopedeNome(" ");
			for(Hospede h:hs){
				System.out.println(h.getNome());
			}
			System.out.println("já Fim");
			}
			/*hospede.setCpf("123098");
			hospede.setNome("Wagner de Souza Silva");
			hospede.setEndereco("Rua sei la");
			hospede.setTelefone("96502332");
			
			if(servico.adicionarHospede(hospede)){
				System.out.println("Hospede cadastrado com sucesso");
			}else{
				System.out.println("Erro ao cadastra hospede");
			}
			//hospede = servico.buscarHospede("123");
			//System.out.println("Hospede encontrado: "+hospede.getNome());
			
			/*
			 * Cadastrando um Hotel
			 */
			/*hotel = new Hotel();
			hotel.setCodigo("123");
			hotel.setEndereco("Rua das ruas");
			hotel.setGerente("Natan Brasileiro");
			
			if(servico.cadastrarHotel(hotel)){
				System.out.println("Hotel cadastro");
			}else{
				System.out.println("Erro Hotel cadastro");
			}
			*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
