package br.com.hotel.util
{
	public class Imagens
	{
		[Embed(source="../imagens/link_funcionarios.png")]
		[Bindable]
		public static var link_funcionarios:Class;
		
		[Embed(source="../imagens/link_hospedes.png")]
		[Bindable]
		public static var link_hospedes:Class;
		
		[Embed(source="../imagens/link_hotel.png")]
		[Bindable]
		public static var link_hotel:Class;
		
		[Embed(source="../imagens/link_reservas.png")]
		[Bindable]
		public static var link_reservas:Class;

		
		[Embed(source="../imagens/add.png")]
		[Bindable]
		public static var adicionar:Class;
		
		
		[Embed(source="../imagens/alter.png")]
		[Bindable]
		public static var alterar:Class;
		
		
		[Embed(source="../imagens/cancel.png")]
		[Bindable]
		public static var cancelar:Class;
		
		
		[Embed(source="../imagens/confirmar.png")]
		[Bindable]
		public static var confirmar:Class;

		[Embed(source="../imagens/search.png")]
		[Bindable]
		public static var localizar:Class;
		
		[Embed(source="../imagens/find.png")]
		[Bindable]
		public static var buscar:Class;

		[Embed(source="../imagens/remover.png")]
		[Bindable]
		public static var excluir:Class;

		[Embed(source="../imagens/hotel.jpg")]
		[Bindable]
		public static var hotel:Class;
		
		public function Imagens()	
		{
		}
	}
}