package com.prueba.cubo.sumatoriaCubo.serviceValidacion;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final Integer SEVERITY_WARNNIN = 1;
	
	private Integer severity;
	
	
	public BaseException(String key,String...args) {
		this(key,SEVERITY_WARNNIN,null,args);
	}
	
	public BaseException(String key,int tipoMensaje,String...args) {
		this(key,tipoMensaje,null,args);
	}

	public BaseException(String mensaje,Integer severityWarnnin,Throwable causa,String...args) {
		super(mensaje,causa);
		severity = severityWarnnin;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

}
