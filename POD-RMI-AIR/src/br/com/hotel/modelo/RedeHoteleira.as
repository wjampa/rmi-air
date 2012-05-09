package br.com.hotel.modelo
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.hotel.modelo.RedeHoteleira")]
	public class RedeHoteleira
	{
		public hoteis:ArrayCollection = new ArrayCollection();
		public hospedes:ArrayCollection = new ArrayCollection();
		public function RedeHoteleira()
		{
		}
	}
}