package javamail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import jdbc.modelo.Ficha;
import jdbc.modelo.Responsavel;
import jdbc.modelo.Usuarios;

public class JavaMailApp {

	// Envia o Email de código para autenticar
	public void enviarCodigo(Usuarios user) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("adotapetpb@gmail.com", "159753Asd@");
			}
		});

		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("adotapetpb@gmail.com"));
			// Remetente

			Address[] toUser = InternetAddress.parse(user.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Olá, " + user.getNome() + "! Autentique seu cadastro no AdotaPet"); // Assunto
			message.setText("Use este codigo para se autenticar: " + user.getCodigo());

			Transport.send(message);

			System.out.println("Feito!!!");
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "E-mail Inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}

	// Envia o Email de Boas Vindas
	public void emailBoasVindas(Usuarios user) {
		Properties props = new Properties();
		/** Parâmetros de conexão com servidor Gmail */

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("adotapetpb@gmail.com", "159753Asd@");
			}
		});

		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("adotapetpb@gmail.com"));
			// Remetente

			Address[] toUser = InternetAddress.parse(user.getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Seja bem vindo(a) ao AdotaPet!"); // Assunto
			message.setText("Olá " + user.getNome() + "! \n"
					+ "Nós do AdotaPet estamos super empolgados com o que você, voluntário(a) (e amigo(a) dos peludos)"
					+ "tem a nos oferecer! Espero que consigamos juntos criar um mundo onde nossos amigos de pêlos "
					+ "possam viver repleto de amor, carinho e em uma casa digna! Conto com você!"
					+ "\n \n Aqui está algumas informações que possam lhe ser úteis: \n" + "E-mail: " + user.getEmail()
					+ "\n" + "Senha: " + user.getSenha() + "\n"
					+ "\n Agora vamos lá! Tenha um ótimo trabalho, muitos lambeijos e seja muito bem vindo(a)!\n");

			Transport.send(message);

			System.out.println("Enviado com sucesso!");
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "E-mail Inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}

	// Verifica se o código digitado é o mesmo do enviado
	public boolean autenticar(Usuarios user) {
		boolean autenticado = false;

		int cod = Integer
				.parseInt(JOptionPane.showInputDialog("Insira o código enviado para\nseu e-mail para se autenticar"));

		if (cod == user.getCodigo()) {
			autenticado = true;
		} else {
			autenticado = false;
		}

		return autenticado;
	}
	
	// Envia o Email de Boas Vindas
		public void emailAdocao(Responsavel resp, Ficha pet) {
			Properties props = new Properties();
			/** Parâmetros de conexão com servidor Gmail */

			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("adotapetpb@gmail.com", "159753Asd@");
				}
			});

			session.setDebug(true);
			
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("adotapetpb@gmail.com"));
				// Remetente

				Address[] toUser = InternetAddress.parse(resp.getEmail());

				message.setRecipients(Message.RecipientType.TO, toUser);
				message.setSubject("Olá " + resp.getNome() + "! Muito obrigado pela sua adoção!"); // Assunto
				message.setText("Estamos super felizes que você pôde levar um de nossos anjos de patas hoje para sua casa!"
						+ "\nEste e-mail é automático, mas nem por isso pense que não é de coração ❤ \n"
						+ "\n"
						+ "Estamos super super supeeeerr felizes de que você adotou nosso anjo " + pet.getNome() + " *-*\n"
						+ "Tenho certeza que ele vai encher sua casa e seu coração de amor e carinho! Espere muitos "
						+ "lamBeijos dele! \n"
						+ "Segue algumas de suas informações que você nos forneceu: \n\n"
						+ "Nome: " + resp.getNome() + " " + resp.getSobrenome() + "\n"
						+ "Endereço: " + resp.getEndereco() + "\nCPF: " + resp.getCpf() + "\nTelefone: " + resp.getTelefone()
						+ "\n\nInformações do Pet: \nNome: " + pet.getNome() + "\nIdade: " + pet.getIdade()
						+ "\nRaca: " + pet.getRaca() + "\nSexo: " + pet.getSexo()
						+ "\n\n Está tudo certinho? Se sim... Bom! Isso é tudo! Obrigado mais uma vez, por contribuir "
						+ "com nossa causa de dar um lar quentinho, aconchegante e principalmente amor para um de nossos"
						+ " peludos, e não esquece de compartilhar com seus amigos ein? Muitos lamBeijos de todos"
						+ "do AdotaPet!");
				
				Transport.send(message);

				System.out.println("Enviado com sucesso!");
			} catch (MessagingException e) {
				JOptionPane.showMessageDialog(null, "E-mail Inválido","ERRO",JOptionPane.ERROR_MESSAGE);
				throw new RuntimeException(e);
			}
		}

}