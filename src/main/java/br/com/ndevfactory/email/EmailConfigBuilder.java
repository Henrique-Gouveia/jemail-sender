package br.com.ndevfactory.email;

import java.util.ResourceBundle;

public class EmailConfigBuilder {
	
	private EmailConfig instance;
	
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
	
	public EmailConfig build() {
		return instance;
	}

}
