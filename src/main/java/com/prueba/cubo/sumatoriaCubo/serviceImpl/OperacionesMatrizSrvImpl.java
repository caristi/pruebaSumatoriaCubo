package com.prueba.cubo.sumatoriaCubo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.cubo.sumatoriaCubo.model.BloqueMatriz;
import com.prueba.cubo.sumatoriaCubo.model.BloqueTexto;
import com.prueba.cubo.sumatoriaCubo.model.Cubo;
import com.prueba.cubo.sumatoriaCubo.service.IOperacionesMatrizSrv;

@Service
public class OperacionesMatrizSrvImpl implements IOperacionesMatrizSrv {
	
	private static int[][][] matriz3D;
	
	private int x1;
	private int y1;
	private int z1;
	private int x2;
	private int y2;
	private int z2;
	
	public List<Integer> calcular(Cubo cubo) {
		
		List<Integer> listaResultados = new ArrayList<>();
		
		int numResulta;
		
		for(BloqueMatriz bloqueMatriz:cubo.getListaBloqueMatriz()) {
			
			inicializarMatriz(bloqueMatriz.getTamanioMatriz());
			
			for(BloqueTexto bloqueTexto:bloqueMatriz.getListaBloqueTextos()) {
				
				if(bloqueTexto.getCoordenasMatriz() != null) {
					
					String[] vectorTexto = bloqueTexto.getCoordenasMatriz().split(" ");
					
					if(bloqueTexto.getOperacion().equals("UPDATE")) {
						actualizarMatriz(vectorTexto);
						
					}else if(bloqueTexto.getOperacion().equals("QUERY")) {
						
						numResulta = calculoSuma(vectorTexto);
						listaResultados.add(numResulta);
					}
				}
		    }
		}
		
		return listaResultados;
	}
	
	private void inicializarMatriz(int tamanio) {
		
		matriz3D = new int[tamanio][tamanio][tamanio];
		
		for(int z=0; z<tamanio; z++) {
			for(int y=0; y<tamanio; y++) {
			  for(int x=0; x<tamanio; x++) {
			    matriz3D[x][y][z] = 0;
			  }
			}
		}
	}
	
	public void actualizarMatriz(String[] vectorTexto) {
		
		int valorActualizar;
		
		x1 = Integer.parseInt(vectorTexto[0]) - 1;
		
		y1 = Integer.parseInt(vectorTexto[1]) - 1;
		
		z1 = Integer.parseInt(vectorTexto[2]) - 1;

		valorActualizar = Integer.parseInt(vectorTexto[3]);
		
		matriz3D[x1][y1][z1] = valorActualizar;
	}
	
	public int calculoSuma(String[] vectorTexto) {
		
		int suma = 0;
		
		x1 = Integer.parseInt(vectorTexto[0]) - 1;
		
		y1 = Integer.parseInt(vectorTexto[1]) - 1;
		
		z1 = Integer.parseInt(vectorTexto[2]) - 1;
		
		x2 = Integer.parseInt(vectorTexto[3]);
		
		y2 = Integer.parseInt(vectorTexto[4]);
		
		z2 = Integer.parseInt(vectorTexto[5]);
		
		for(int z=z1; z<z2; z++) {
			for(int y=y1; y<y2; y++) {
			  for(int x=x1; x<x2; x++) {
			    suma = suma + matriz3D[x][y][z];
			    
			  }
			}
		}
		
		return suma;
	}
	
}
