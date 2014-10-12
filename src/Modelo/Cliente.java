package Modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class Cliente {

	

	private String user;
	private String password;
	private String smtpHostG;
	private String smtpHostH;
	
	
	public Cliente (String user,String password){
		
		this.setPassword(password);
		this.setUser(user);
		this.smtpHostG="smtp.gmail.com";
		this.smtpHostH="smtp.live.com";
		
	}
	
	public Properties initPropertiesGmail(){
		Properties propsG = new Properties();
		 
		propsG.put("mail.smtp.host",smtpHostG);
		propsG.put("mail.transport.protocol","smtp");
		propsG.put("mail.smtp.auth", "true");
		propsG.setProperty("mail.user", user);
		propsG.setProperty("mail.password", password);
		
		return propsG;
	}
	
	public Properties initPropertiesHotmail(){
		Properties propsH = new Properties();
		 
		propsH.put("mail.smtp.host",smtpHostH);
		propsH.put("mail.transport.protocol","smtp");
		propsH.put("mail.smtp.auth", "true");
		propsH.setProperty("mail.user", user);
		propsH.setProperty("mail.password", password);
		
		return propsH;
	}
	
	public void enviarCorreoPlano(String asunto, String cuerpo, String receptor){
		SMTPTransport transport = null;
			Session sesion = null;
			if (user.contains("gmail")){
				
				sesion = Session.getInstance(initPropertiesGmail(),null);
				
			}else if (user.contains("hotmail")){
				
				sesion = sesion.getInstance(initPropertiesHotmail(),null);
			}
			
			Message mensaje = new MimeMessage(sesion);
		try {
		
		//Completa atributos 
		
		//Asunto
		mensaje.setSubject(asunto);
		
		//Emisor
		mensaje.setFrom(new InternetAddress(user));
		
		//Receptor
		mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
		
		//Cuerpo del Mensaje
		mensaje.setText(cuerpo);
		
		
        transport = (SMTPTransport) sesion.getTransport("smtp");
        
            //conectar al servidor
            transport.connect(user, password);
            //enviar el mensaje
            
            transport.send(mensaje);
		}catch (Exception e) {
			System.err.println(e.getMessage());
        }
		
		
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

}