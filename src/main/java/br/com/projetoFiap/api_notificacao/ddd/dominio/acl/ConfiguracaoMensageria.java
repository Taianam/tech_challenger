package br.com.projetoFiap.api_notificacao.ddd.dominio.acl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class ConfiguracaoMensageria {
	
	public static final String ACCOUNT_SID = "SID_TWILIO";
    public static final String AUTH_TOKEN = "TOKEN_TWILIO";
    
    
    public void enviaWhatssap(String telefone, String mensagem) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Message.creator(
                new PhoneNumber("whatsapp:+55"+telefone),
                new PhoneNumber("whatsapp:+14155238886"),
                mensagem)
            .create();
    }
    
}
