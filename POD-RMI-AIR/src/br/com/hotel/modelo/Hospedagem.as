package br.com.hotel.modelo
{
	[Bindable]
	[RemoteClass(alias="br.com.hotel.modelo.Hospedagem")]
	public class Hospedagem
	{
		public var dataInicioHospedagem:Date;
		public var dataFimHospedagem:Date;
		public var hospede:Hospede;
		public var reserva:Reserva;
		public var pago:Boolean;
		public function Hospedagem()
		{
		}
	}
}