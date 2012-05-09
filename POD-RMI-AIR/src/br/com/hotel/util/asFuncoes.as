import br.com.hotel.modelo.Hospede;
import br.com.hotel.views.carregando.TelaCarregando;
import br.com.hotel.views.erro.ErroException;
import br.com.hotel.views.hospede.TelaPrincipalHospede;
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
//public var telaCarregando:telaCarregando;i]
[Bindable]
public var objHospedeSelecionado:Hospede = new Hospede();

public function abrirErroException():void {
	telaErroException = PopUpManager.createPopUp(this, ErroException, true) as ErroException;
	centralizarTela(telaErroException);
}
public function abrirPrincipalHospede():void {
	telaPrincipalHospede = PopUpManager.createPopUp(this, TelaPrincipalHospede, true) as TelaPrincipalHospede;
	centralizarTela(telaPrincipalHospede);
}
public function abrirPrincipalHotel():void {
	telaPrincipalHotel = PopUpManager.createPopUp(this, TelaPrincipalHotel, true) as TelaPrincipalHotel;
	centralizarTela(telaPrincipalHotel);
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