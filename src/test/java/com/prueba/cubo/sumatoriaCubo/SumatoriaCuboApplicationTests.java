package com.prueba.cubo.sumatoriaCubo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prueba.cubo.sumatoriaCubo.model.BloqueMatriz;
import com.prueba.cubo.sumatoriaCubo.model.BloqueTexto;
import com.prueba.cubo.sumatoriaCubo.model.Cubo;
import com.prueba.cubo.sumatoriaCubo.service.IOperacionesMatrizSrv;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SumatoriaCuboApplicationTests {

	@Autowired
	private IOperacionesMatrizSrv iOperacionesMatrizSrv;
	
	
	/** Este test se realiza con los mismo datos en el ejemplo que muestra en la pagina
	 *      https://www.hackerrank.com/challenges/cube-summation/problem 
	 * */
	@Test
	public void testSumatoriaOperacionCubo() {
		
		List<Integer> listaExperada = new ArrayList<>();
		listaExperada.add(4);
		listaExperada.add(4);
		listaExperada.add(27);
		listaExperada.add(0);
		listaExperada.add(1);
		listaExperada.add(1);
		
		Cubo cubo = new Cubo();
		cubo.setNumeroCasosPrueba(2);
		List<BloqueMatriz> listaBloqueMatriz = new ArrayList<>();
		
		/* 4 5
		*  UPDATE 2 2 2 4
		*  QUERY 1 1 1 3 3 3
		*  UPDATE 1 1 1 23
		*  QUERY 2 2 2 4 4 4
		*  QUERY 1 1 1 3 3 3
		*/
		List<BloqueTexto> listaBloqueTextos = new ArrayList<>();
		
		BloqueTexto bloqueTexto1 = new BloqueTexto();
		bloqueTexto1.setOperacion("UPDATE");
		bloqueTexto1.setCoordenadasMatriz("2 2 2 4");
		listaBloqueTextos.add(bloqueTexto1);
		
		BloqueTexto bloqueTexto2 = new BloqueTexto();
		bloqueTexto2.setOperacion("QUERY");
		bloqueTexto2.setCoordenadasMatriz("1 1 1 3 3 3");
		listaBloqueTextos.add(bloqueTexto2);
		
		BloqueTexto bloqueTexto3 = new BloqueTexto();
		bloqueTexto3.setOperacion("UPDATE");
		bloqueTexto3.setCoordenadasMatriz("1 1 1 23");
		listaBloqueTextos.add(bloqueTexto3);
		
		BloqueTexto bloqueTexto4 = new BloqueTexto();
		bloqueTexto4.setOperacion("QUERY");
		bloqueTexto4.setCoordenadasMatriz("2 2 2 4 4 4");
		listaBloqueTextos.add(bloqueTexto4);
		
		BloqueTexto bloqueTexto5 = new BloqueTexto();
		bloqueTexto5.setOperacion("QUERY");
		bloqueTexto5.setCoordenadasMatriz("1 1 1 3 3 3");
		listaBloqueTextos.add(bloqueTexto5);
		
		BloqueMatriz bloqueMatriz1 = new BloqueMatriz();
		
		bloqueMatriz1.setTamanioMatriz(4);
		bloqueMatriz1.setCantidadOperacion(5);
		bloqueMatriz1.setListaBloqueTextos(listaBloqueTextos);
		
		listaBloqueMatriz.add(bloqueMatriz1);
		
		cubo.setListaBloqueMatriz(listaBloqueMatriz);
		
		/*  2 4
		*	UPDATE 2 2 2 1
		*	QUERY 1 1 1 1 1 1
		*	QUERY 1 1 1 2 2 2
		*	QUERY 2 2 2 2 2 2
		*/
		List<BloqueTexto> listaBloqueTextos2 = new ArrayList<>();
		
		BloqueTexto bloqueTexto2_1 = new BloqueTexto();
		bloqueTexto2_1.setOperacion("UPDATE");
		bloqueTexto2_1.setCoordenadasMatriz("2 2 2 1");
		listaBloqueTextos2.add(bloqueTexto2_1);
		
		BloqueTexto bloqueTexto2_2 = new BloqueTexto();
		bloqueTexto2_2.setOperacion("QUERY");
		bloqueTexto2_2.setCoordenadasMatriz("1 1 1 1 1 1");
		listaBloqueTextos2.add(bloqueTexto2_2);
		
		BloqueTexto bloqueTexto2_3 = new BloqueTexto();
		bloqueTexto2_3.setOperacion("QUERY");
		bloqueTexto2_3.setCoordenadasMatriz("1 1 1 2 2 2");
		listaBloqueTextos2.add(bloqueTexto2_3);
		
		BloqueTexto bloqueTexto2_4 = new BloqueTexto();
		bloqueTexto2_4.setOperacion("QUERY");
		bloqueTexto2_4.setCoordenadasMatriz("2 2 2 2 2 2");
		listaBloqueTextos2.add(bloqueTexto2_4);
		
		BloqueMatriz bloqueMatriz2 = new BloqueMatriz();
		
		bloqueMatriz2.setTamanioMatriz(2);
		bloqueMatriz2.setCantidadOperacion(4);
		bloqueMatriz2.setListaBloqueTextos(listaBloqueTextos2);
		
		listaBloqueMatriz.add(bloqueMatriz2);
		
		cubo.setListaBloqueMatriz(listaBloqueMatriz);
		
		assertEquals(listaExperada,iOperacionesMatrizSrv.calcular(cubo));
	}
	
	
	@Test
	public void testSumatoriaCuboConUnSoloCaso() {
		
		List<Integer> listaExperada = new ArrayList<>();
		listaExperada.add(4);
		listaExperada.add(4);
		listaExperada.add(27);
		
		List<BloqueTexto> listaBloqueTextos = new ArrayList<>();
		
		BloqueTexto bloqueTexto1 = new BloqueTexto();
		bloqueTexto1.setOperacion("UPDATE");
		bloqueTexto1.setCoordenadasMatriz("2 2 2 4");
		listaBloqueTextos.add(bloqueTexto1);
		
		BloqueTexto bloqueTexto2 = new BloqueTexto();
		bloqueTexto2.setOperacion("QUERY");
		bloqueTexto2.setCoordenadasMatriz("1 1 1 3 3 3");
		listaBloqueTextos.add(bloqueTexto2);
		
		BloqueTexto bloqueTexto3 = new BloqueTexto();
		bloqueTexto3.setOperacion("UPDATE");
		bloqueTexto3.setCoordenadasMatriz("1 1 1 23");
		listaBloqueTextos.add(bloqueTexto3);
		
		BloqueTexto bloqueTexto4 = new BloqueTexto();
		bloqueTexto4.setOperacion("QUERY");
		bloqueTexto4.setCoordenadasMatriz("2 2 2 4 4 4");
		listaBloqueTextos.add(bloqueTexto4);
		
		BloqueTexto bloqueTexto5 = new BloqueTexto();
		bloqueTexto5.setOperacion("QUERY");
		bloqueTexto5.setCoordenadasMatriz("1 1 1 3 3 3");
		listaBloqueTextos.add(bloqueTexto5);
		
		BloqueMatriz bloqueMatriz1 = new BloqueMatriz();
		
		bloqueMatriz1.setTamanioMatriz(4);
		bloqueMatriz1.setCantidadOperacion(5);
		bloqueMatriz1.setListaBloqueTextos(listaBloqueTextos);
		
		List<BloqueMatriz> listaBloqueMatriz = new ArrayList<>();
		listaBloqueMatriz.add(bloqueMatriz1);
		
		Cubo cubo = new Cubo();
		cubo.setNumeroCasosPrueba(1);
		cubo.setListaBloqueMatriz(listaBloqueMatriz);
		
		assertEquals(listaExperada,iOperacionesMatrizSrv.calcular(cubo));
	}

}
