package br.com.hotel.modelo{
	[Bindable]
	[RemoteClass(alias="br.com.hotel.modelo.Reserva")]
	public class Reserva
	{
		public var dataReserva:Date = new Date();
		public var dataInicio:Date;
		public var dataFim:Date;
		public var hospede:Hospede;
		public var quarto:Quarto;
		public var hospedagem:Hospedagem;
		public function Reserva()
		{
		}
	}
}