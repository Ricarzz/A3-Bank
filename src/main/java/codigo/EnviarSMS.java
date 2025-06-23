package codigo;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class EnviarSMS {

    public static final String ACCOUNT_SID = "SID_TWILIO";
    public static final String AUTH_TOKEN = "TOKEN_TWILIO";
    public static final String NUMERO_TWILIO = "NÚMERO_VERIFICADO"; // número verificado no Twilio

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); // inicializa só uma vez
    }

    public static void enviarSMS(String telefone, String mensagemTexto) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(telefone),
                    new PhoneNumber(NUMERO_TWILIO),
                    mensagemTexto)
                .create();

            System.out.println("Mensagem enviada com SID: " + message.getSid());
        } catch (Exception e) {
            System.err.println("Erro ao enviar SMS: " + e.getMessage());
        }
    }
}
