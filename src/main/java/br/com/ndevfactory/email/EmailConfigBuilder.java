package br.com.ndevfactory.email;

import java.util.ResourceBundle;

public class EmailConfigBuilder {
	
	private EmailConfig instance;
	
	public EmailConfigBuilder() {
		this.instance = new EmailConfig();
	}

	private void createAndLoadEmailConfig(ResourceBundle resource) {
		this.instance = new EmailConfig();
		
		this.instance.setHostName(resource.getString(EmailConsts.BUNDLE_KEY_HOST_NAME));
		this.instance.setSmtpPort(Integer.parseInt(resource.getString(EmailConsts.BUNDLE_KEY_SMTP_PORT)));
		this.instance.setSsl(Boolean.parseBoolean(resource.getString(EmailConsts.BUNDLE_KEY_SSL)));
		this.instance.setFromName(resource.getString(EmailConsts.BUNDLE_KEY_FROM_NAME));
		this.instance.setFromEmail(resource.getString(EmailConsts.BUNDLE_KEY_FROM_EMAIL));
		this.instance.setFromPassword(resource.getString(EmailConsts.BUNDLE_KEY_FROM_PASSWORD));
	}
	
	public EmailConfigBuilder fromBundle() {
		ResourceBundle resource = ResourceBundle.getBundle(EmailConsts.BUNDLE_NAME);
		createAndLoadEmailConfig(resource);
		return this;
	}
	
	public EmailConfigBuilder withHostName(final String hostName) {
		this.instance.setHostName(hostName);
		return this;
	}
	
	public EmailConfigBuilder withSmtpPort(final Integer smtpPort) {
		this.instance.setSmtpPort(smtpPort);
		return this;
	}
	
	public EmailConfigBuilder withSsl(final Boolean ssl) {
		this.instance.setSsl(ssl);
		return this;
	}
	
	public EmailConfigBuilder withFromName(final String fromName) {
		this.instance.setFromName(fromName);
		return this;
	}
	
	public EmailConfigBuilder withFromEmail(final String fromEmail) {
		this.instance.setFromEmail(fromEmail);
		return this;
	}
	
	public EmailConfigBuilder withFromPassword(final String fromPassword) {
		this.instance.setFromPassword(fromPassword);
		return this;
	}
	
	public EmailConfig build() {
		return instance;
	}

}
