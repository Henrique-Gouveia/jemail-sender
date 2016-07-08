package br.com.ndevfactory.email;

import java.util.List;

import br.com.ndevfactory.email.contato.Contato;
import br.com.ndevfactory.email.contato.Contatos;

public abstract class EmailSender {

	protected EmailConfig config;

	public EmailSender(EmailConfig config) {
		this.config = config;
	}

	public boolean send(String subject, String message) {
		Email email = getEmailConfigured();
		List<Contato> contatos = getContatos().getAll();

		for (Contato contato : contatos) {
			email.addTo(contato.getEmail(), contato.getNome());
		}

		email.setSubject(subject);
		email.setMsg(message);

		return email.send();
	}

	protected abstract Contatos getContatos();

	protected abstract Email getEmail();

	private Email getEmailConfigured() {
		Email email = getEmail();

		email.setHostName(config.getHostName());
		email.setSmtpPort(config.getSmtpPort());
		email.setSSLOnConnect(config.isSsl());
		email.setAuthentication(config.getFromEmail(), config.getFromPassword());
		email.setFrom(config.getFromEmail(), config.getFromName());

		return email;
	}
}
