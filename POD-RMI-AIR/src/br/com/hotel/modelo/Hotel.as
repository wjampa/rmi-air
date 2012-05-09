package br.com.hotel.modelo
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.hotel.modelo.Hotel")]
	public class Hotel
	{
		public var codigo:String;
		public var endereco:String;
		public var gerente:String;
		public var nome:String;
		public var telefone:String;
		public var quartos:ArrayCollection = new ArrayCollection();
		public var reservas:ArrayCollection = new ArrayCollection();
		public function Hotel()
		{
		}
	}
}