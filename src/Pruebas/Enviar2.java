package Pruebas;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class Enviar2 {
public static void main (String [] args) {
// Se comprueba que el número de argumentos es el correcto
//if (args.length != 2) {
//System.out.println( "Ha de enviar dos parámetros \n" +
//"java EnviarCorreo fromAddress toAddress");
//System.exit(1);
//}
// Se obtienen el from y el to recibidos como parámetros
String from = "juanfe.2793@gmail.com";
String to = "juanfe.2793@gmail.com";
// Se obtienen las propiedades del sistema y se establece el servidor SMTP
String smtpHost = "smtp.google.com";
Properties props = System.getProperties();
props.put("mail.smtp.host",smtpHost);
// Se obtiene una sesión con las propiedades anteriormente definidas
Session sesion = Session.getDefaultInstance(props,null);
// Capturar las excepciones
try {
// Se crea un mensaje vacío
Message mensaje = new MimeMessage(sesion);
// Se rellenan los atributos y el contenido
// Asunto
mensaje.setSubject("Hola Mundo");
// Emisor del mensaje
mensaje.setFrom(new InternetAddress(from));
//Receptor del mensaje
mensaje.addRecipient( Message.RecipientType.TO,
new InternetAddress(to));
//Cuerpo del mensaje
mensaje.setText("Este es el cuerpo del mensaje");
//Se envía el mensaje
Transport.send(mensaje);
} catch (MessagingException e) {
System.err.println(e.getMessage());
}
}
}