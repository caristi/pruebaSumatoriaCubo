package com.prueba.cubo.sumatoriaCubo.serviceValidacion;


import org.springframework.stereotype.Service;

import com.prueba.cubo.sumatoriaCubo.Constantes.IConstantes;
import com.prueba.cubo.sumatoriaCubo.model.BloqueMatriz;
import com.prueba.cubo.sumatoriaCubo.model.Cubo;

@Service
public class ValidacionesSumaCubo {
	
	public void validarDatosCubo(Cubo cubo) {
		
		if(cubo.getNumeroCasosPrueba() < 1 || cubo.getNumeroCasosPrueba() > 50) {
			throw new NegocioException("El Cantidad casos debe ser entre 1 y 50", BaseException.SEVERITY_WARNNIN);
		}
	}
	
	public void validarDatosBloqueMatriz(BloqueMatriz bloqueMatriz) {
		
		if(bloqueMatriz.getTamanioMatriz() < 1 || bloqueMatriz.getTamanioMatriz() > 100) {
			throw new NegocioException("El Tamaño de la Matriz debe ser entre 1 y 100", BaseException.SEVERITY_WARNNIN);
		}
		
		if(bloqueMatriz.getCantidadOperacion() < 1 || bloqueMatriz.getCantidadOperacion() > 1000) {
			throw new NegocioException("El Cantidad de operaciones debe ser entre 1 y 1000", BaseException.SEVERITY_WARNNIN);
		}
	}
	
	public void validarDatosBloqueTextoUpdate(int x1, int y1, int z1,int tamanioMatriz) {
		
		validarNoSupereTamañoMatriz(x1,tamanioMatriz);
		validarNoSupereTamañoMatriz(y1,tamanioMatriz);
		validarNoSupereTamañoMatriz(z1,tamanioMatriz);
		
		if(x1 < IConstantes.MIN_COORDENADA) {
			throw new NegocioException("Una de las coordenadas está errada", BaseException.SEVERITY_WARNNIN);
		}
		
		if(y1 < IConstantes.MIN_COORDENADA) {
			throw new NegocioException("Una de las coordenadas está errada", BaseException.SEVERITY_WARNNIN);
		}
		
		if(z1 < IConstantes.MIN_COORDENADA) {
			throw new NegocioException("Una de las coordenadas está errada", BaseException.SEVERITY_WARNNIN);
		}
	}
	
	public void validarDatosBloqueTextoQuery(int x1, int x2, int y1, int y2, int z1,int z2, int tamanioMatriz) {
		
		validarNoSupereTamañoMatriz(x1,tamanioMatriz);
		validarNoSupereTamañoMatriz(x2,tamanioMatriz);
		validarNoSupereTamañoMatriz(y1,tamanioMatriz);
		validarNoSupereTamañoMatriz(y2,tamanioMatriz);
		validarNoSupereTamañoMatriz(z1,tamanioMatriz);
		validarNoSupereTamañoMatriz(z2,tamanioMatriz);
		
		if(x1 < IConstantes.MIN_COORDENADA || x1 > x2 || x2 < IConstantes.MIN_COORDENADA) {
			throw new NegocioException("Una de las coordenadas está errada", BaseException.SEVERITY_WARNNIN);
		}
		
		if(y1 < IConstantes.MIN_COORDENADA || y1 > y2 || y2 < IConstantes.MIN_COORDENADA) {
			throw new NegocioException("Una de las coordenadas está errada", BaseException.SEVERITY_WARNNIN);
		}
		
		if(z1 < IConstantes.MIN_COORDENADA || z1 > z2 || z2 < IConstantes.MIN_COORDENADA) {
			throw new NegocioException("Una de las coordenadas está errada", BaseException.SEVERITY_WARNNIN);
		}
	}
	
	public void validarNoSupereTamañoMatriz(int numero, int tamanioMatriz) {
		
		if(numero < 1 || numero > tamanioMatriz ) {
			throw new NegocioException("Una de las coordenadas es mayor el tamaño de la matriz", BaseException.SEVERITY_WARNNIN);
		}
	}
	
	public void validarNumeroActualizar(int numeroActualizar) {
		
		if(numeroActualizar > IConstantes.MAX_NUMERO || numeroActualizar < IConstantes.MIN_NUMERO) {
			throw new NegocioException("El número actualizar debe ser entre " + IConstantes.MIN_NUMERO + " y " + IConstantes.MAX_NUMERO , BaseException.SEVERITY_WARNNIN);
		}
	}
	
	public void validarTextoOperacion(String texto) {
		
		if(!texto.equals(IConstantes.QUERY) || !texto.equals(IConstantes.UPDATE)) {
			throw new NegocioException("El texto debe ser " + IConstantes.QUERY + " o "  + IConstantes.UPDATE, BaseException.SEVERITY_WARNNIN);
		}
	}
	

}
