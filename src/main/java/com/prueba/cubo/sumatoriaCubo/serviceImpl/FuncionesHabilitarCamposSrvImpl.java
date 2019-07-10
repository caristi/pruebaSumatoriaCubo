package com.prueba.cubo.sumatoriaCubo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.cubo.sumatoriaCubo.model.BloqueMatriz;
import com.prueba.cubo.sumatoriaCubo.model.BloqueTexto;
import com.prueba.cubo.sumatoriaCubo.model.Cubo;
import com.prueba.cubo.sumatoriaCubo.service.IFuncionesHabilitarCamposSrv;

@Service
public class FuncionesHabilitarCamposSrvImpl implements IFuncionesHabilitarCamposSrv{

	@Override
	public Cubo habilitaCantidadCasos(Cubo cubo) {

		if(cubo.getNumeroCasosPrueba() > 0) {
			
			List<BloqueMatriz> listaBloque = inicializarBloqueMatriz(cubo.getNumeroCasosPrueba());
			cubo.setListaBloqueMatriz(listaBloque);
		}
		
		return cubo;
	}
	
	public BloqueMatriz habilitarBloqueTextos(BloqueMatriz bloqueMatriz) {
		
		if(bloqueMatriz.getCantidadOperacion() > 0) {
			bloqueMatriz.setListaBloqueTextos(inicializarListaOperaciones(bloqueMatriz.getCantidadOperacion()));
		}
		
		return bloqueMatriz;
	}

	private List<BloqueMatriz> inicializarBloqueMatriz(int numeroCasos) {
		
		List<BloqueMatriz> listaBloque = new ArrayList<BloqueMatriz>();
		
		for(int i = 1; i <= numeroCasos; i++) {
			BloqueMatriz bloqueMatriz = new BloqueMatriz();
			bloqueMatriz.setNumero(i);
			bloqueMatriz.setListaBloqueTextos(new ArrayList<BloqueTexto>());
			
			listaBloque.add(bloqueMatriz);
		}
		
		return listaBloque;
	}
	
	private List<BloqueTexto> inicializarListaOperaciones(int cantidadOperaciones){
		
		List<BloqueTexto> listaBloqueTexto = new ArrayList<BloqueTexto>();
		
		for(int i = 1; i <= cantidadOperaciones; i++) {
			BloqueTexto bloqueTexto = new BloqueTexto();
			listaBloqueTexto.add(bloqueTexto);
		}
		
		return listaBloqueTexto;
		
	}
}
