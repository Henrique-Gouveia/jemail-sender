package br.com.ndevfactory.email;

public interface Email {
	
	public void setDebug(boolean debug);
	
	public String getHostName();
	public void setHostName(String hostName);
	

	public String getSmtpPort();
	public void setSmtpPort(Integer portNumber);
	
	public Email setSSLOnConnect(boolean ssl);
	public void setAuthentication(String userName, String userPassword);
	
	public Email setFrom(String email, String name);
	public Email addTo(String email, String name);

	public String getSubject();
	public Email setSubject(String subject);
	
	public Email setMsg(String message);

	public boolean send();
}
