package codigo;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.PasswordAuthentication;



public class EnviarEmail {

    public static void enviarCodigoVerificacao(String destinatario, String codigo) {
        // Dados do remetente (e-mail que vai enviar o código)
        String remetente = "SEU_EMAIL"; // troque pelo seu e-mail
        String senha = "SUA_SENHA_APP";       // troque pela senha de app do Gmail

        // Configuração do servidor SMTP (Gmail neste caso)
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Autenticação
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            // Criando o e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
            message.setSubject("-Código de verificação-");
            message.setText("Seu código de verificação é: " + codigo);

            // Enviando
            Transport.send(message);
            System.out.println("E-mail enviado com sucesso para " + destinatario);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

