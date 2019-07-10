package com.prueba.cubo.sumatoriaCubo.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BloqueMatriz {
	
	private int numero;
	private int tamanioMatriz;
	private int cantidadOperacion;
	private List<BloqueTexto> listaBloqueTextos;
	

}
