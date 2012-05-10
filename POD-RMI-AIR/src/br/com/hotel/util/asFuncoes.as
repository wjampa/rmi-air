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
import br.com.hotel.views.quarto.PrincipalQuarto;
import br.com.hotel.views.reserva.TelaPrincipalReserva;

import mx.core.UIComponent;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;

public var erroInformado:String = new String();



public var telaErroException:ErroException;
public var telaPrincipalHospede:TelaPrincipalHospede;
public var telaPrincipalHotel:TelaPrincipalHotel;
public var telaPrincipalQuartos:PrincipalQuarto;
public var telaPrincipalReserva:TelaPrincipalReserva;


public var principalHospede:PrincipalHospede;
public var novoHospede:NovoHospede;

public var principalHotel:PrincipalHotel;
public var novoHotel:NovoHotel;
//public var telaCarregando:telaCarregando;i]

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
/*
 *Fim Objetos 
 */


public function abrirErroException():void {
	telaErroException = PopUpManager.createPopUp(this, ErroException, true) as ErroException;
	centralizarTela(telaErroException);
}
/*
 *Tela para hospedes 
*/
public function abrirPrincipalHospede():void {
	principalHospede = PopUpManager.createPopUp(this,PrincipalHospede, true) as PrincipalHospede;
	centralizarTela(principalHospede);
}
public function abrirNovoHospede():void {
	novoHospede = PopUpManager.createPopUp(this,NovoHospede, true) as NovoHospede;
	centralizarTela(novoHospede);
}



public function abrirPrincipalHotel():void {
	principalHotel = PopUpManager.createPopUp(this, PrincipalHotel, true) as PrincipalHotel;
	centralizarTela(principalHotel);
}
public function abrirNovoHotel():void {
	novoHotel = PopUpManager.createPopUp(this,NovoHotel, true) as NovoHotel;
	centralizarTela(novoHotel);
}


public function abrirPrincipalQuarto():void {
	telaPrincipalQuartos = PopUpManager.createPopUp(this, PrincipalQuarto, true) as PrincipalQuarto;
	centralizarTela(telaPrincipalQuartos);
}
public function abrirPrincipalReserva():void {
	telaPrincipalReserva = PopUpManager.createPopUp(this, TelaPrincipalReserva, true) as TelaPrincipalReserva;
	centralizarTela(telaPrincipalReserva);
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
public function calcRowColor(item:Object, rowIndex:int, dataIndex:int, color:uint):uint {
	if (item.status == "EM ABERTO")
		return 0xE2E8F4;
	else if (item.status == "EM PROCESSO")
		return 0xFFEFDB;
	else if (item.status == "PRONTO")
		return 0xC1FFC1;
	else if (item.status == "ENTREGUE")
		return 0xFFFACD;
	else
		return color;
}