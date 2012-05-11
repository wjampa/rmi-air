package br.com.hotel.modelo
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.hotel.modelo.Quarto")]
	public class Quarto
	{
		public var num:Number;
		public var andar:String;
		public var status:String;
		public var preco:Number;
		public var reservas:ArrayCollection = new ArrayCollection();
		public var hospedagens:ArrayCollection = new ArrayCollection();
		public function Quarto()
		{
		}
	}
}