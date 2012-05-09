package br.com.hotel.modelo
{
	import mx.collections.ArrayCollection;
	import mx.rpc.remoting.mxml.RemoteObject;

	[Bindable]
	[RemoteClass(alias="br.com.hotel.modelo.Hospede")]
	public class Hospede
	{
		public var nome:String;
		public var telefone:String;
		public var endereco:String;
		public var cpf:String;
		public var numero:String;
		public var reservas:ArrayCollection = new ArrayCollection();
		public function Hospede()
		{
		}
	}
}