package com.prueba.cubo.sumatoriaCubo.serviceValidacion;

public class NegocioException extends BaseException{

	private static final long serialVersionUID = 1L;

	public NegocioException(String key, String[] args) {
		super(key, args);
	}
	
	public NegocioException(String mensaje,int tipoMensaje, String... args) {
		super(mensaje,tipoMensaje,args);
	}
}
