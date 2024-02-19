package br.com.leonardosr.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String mensage;
	private String details;
	
	public ExceptionResponse(Date timestamp, String mensage, String details) {
		this.timestamp = timestamp;
		this.mensage = mensage;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensage() {
		return mensage;
	}

	public String getDetails() {
		return details;
	}
}
