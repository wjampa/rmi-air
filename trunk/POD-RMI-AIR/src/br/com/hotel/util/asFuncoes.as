import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.Hotel;
import br.com.hotel.modelo.Quarto;
import br.com.hotel.modelo.Reserva;
import br.com.hotel.views.carregando.TelaCarregando;
import br.com.hotel.views.erro.ErroException;
import br.com.hotel.views.hospede.NovoHospede;
import br.com.hotel.views.hospede.PrincipalHospede;
import br.com.hotel.views.hospede.TelaPrincipalHospede;
import br.com.hotel.views.hotel.NovoHotel;
import br.com.hotel.views.hotel.PrincipalHotel;
import br.com.hotel.views.hotel.TelaPrincipalHotel;
import br.com.hotel.views.quarto.NovoQuarto;
import br.com.hotel.views.quarto.PrincipalQuarto;
import br.com.hotel.views.quarto.TelaPrincipalQuarto;
import br.com.hotel.views.reserva.PrincipalReserva;
import br.com.hotel.views.reserva.TelaPrincipalReserva;

import mx.collections.ArrayCollection;
import mx.core.UIComponent;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;

public var erroInformado:String = new String();



public var telaErroException:ErroException;
public var telaPrincipalHospede:TelaPrincipalHospede;
public var telaPrincipalHotel:TelaPrincipalHotel;
public var telaPrincipalQuartos:TelaPrincipalQuarto;
public var telaPrincipalReserva:TelaPrincipalReserva;


public var principalHospede:PrincipalHospede;
public var novoHospede:NovoHospede;

public var principalHotel:PrincipalHotel;
public var novoHotel:NovoHotel;

public var principalQuartos:PrincipalQuarto;
public var novoQuarto:NovoQuarto;

public var principalReserva:PrincipalReserva;
//public var telaCarregando:telaCarregando;i]

public var meses:Array = ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'];
/*
 *Objeto que serão utilizados em toda a plicacao 
*/
[Bindable]
public var objHospedeSelecionado:Hospede = new Hospede();

[Bindable]
public var objHotelSelecionado:Hotel = new Hotel();

[Bindable]
public var objQuartoSelecionado:Quarto = new Quarto();

[Binable]
public var objReservaSelecionada:Reserva = new Reserva();

[Bindable]
public var listaHoteis:ArrayCollection = new ArrayCollection();

[Bindable]
public var listaQuartos:ArrayCollection = new ArrayCollection();

/*
 *Fim Objetos 
 */


public function abrirErroException():void {
	telaErroException = PopUpManager.createPopUp(this, ErroException, true) as ErroException;
	centralizarTela(telaErroException);
}
/*
 *Telas para hospedes 
*/
public function abrirPrincipalHospede():void {
	principalHospede = PopUpManager.createPopUp(this,PrincipalHospede, true) as PrincipalHospede;
	centralizarTela(principalHospede);
}
public function abrirNovoHospede():void {
	novoHospede = PopUpManager.createPopUp(this,NovoHospede, true) as NovoHospede;
	centralizarTela(novoHospede);
}
/*
*Telas para hotel
*/
public function abrirPrincipalHotel():void {
	principalHotel = PopUpManager.createPopUp(this, PrincipalHotel, true) as PrincipalHotel;
	centralizarTela(principalHotel);
}
public function abrirNovoHotel():void {
	novoHotel = PopUpManager.createPopUp(this,NovoHotel, true) as NovoHotel;
	centralizarTela(novoHotel);
}


/*
*Telas para quartos
*/
public function abrirPrincipalQuarto():void {
	principalQuartos = PopUpManager.createPopUp(this, PrincipalQuarto, true) as PrincipalQuarto;
	centralizarTela(principalQuartos);
}

public function abrirNovoQuarto():void {
	novoQuarto = PopUpManager.createPopUp(this,NovoQuarto, true) as NovoQuarto;
	centralizarTela(novoQuarto);
}

public function abrirPrincipalReserva():void {
	principalReserva = PopUpManager.createPopUp(this, PrincipalReserva, true) as PrincipalReserva;
	centralizarTela(principalReserva);
}
/*public function abrirCarregando(texto:String):void{
	telaCarregando = PopUpManager.createPopUp(this, telaCarregando, true) as telaCarregando;
	telaCarregando.barraProgresso.label = texto;
	centralizarTela(telaCarregando);
}
public function fecharCarregando():void{
	PopUpManager.removePopUp(this.telaCarregando);
}*/
public function onFault(event:FaultEvent):void {
	erroInformado = new String();
	erroInformado += event.token.message.destination;
	erroInformado += "\n";
	erroInformado += (event.fault.faultDetail + " - " + event.fault.faultString);
	abrirErroException();
}
public function centralizarTela(componente:UIComponent):void {
	if (componente != null) {
		var diferencaLargura:Number = componente.screen.width - componente.width;
		var diferencaAltura:Number = componente.screen.height - componente.height;
		componente.x = componente.screen.x + (diferencaLargura / 2);
		componente.y = componente.screen.y + (diferencaAltura / 2);
		componente.isPopUp = false;
	}
}
public function fechar(componente:UIComponent):void {
	PopUpManager.removePopUp(componente);
}
