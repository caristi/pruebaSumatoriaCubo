package com.prueba.cubo.sumatoriaCubo.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.prueba.cubo.sumatoriaCubo.model.BloqueMatriz;
import com.prueba.cubo.sumatoriaCubo.model.Cubo;
import com.prueba.cubo.sumatoriaCubo.service.IFuncionesHabilitarCamposSrv;
import com.prueba.cubo.sumatoriaCubo.service.IOperacionesMatrizSrv;

@Scope(value = "session")
@Component(value = "cuboController")
@ELBeanName(value = "cuboController")
@Join(path = "/cubo", to = "/prueba.jsf")
public class CuboController {
	
	@Autowired
	private IFuncionesHabilitarCamposSrv iFuncionesHabilitarCamposSrv;
	
	@Autowired
	private IOperacionesMatrizSrv iOperacionesMatrizSrv;

	private Cubo cubo; 
	
	private List<Integer> listaResultados;
	
	public CuboController() {
		cubo = new Cubo();
	}
	
	public void habilitaCantidadCasos() {
		iFuncionesHabilitarCamposSrv.habilitaCantidadCasos(cubo);
    }
	
	public void habilitarBloqueTextos(BloqueMatriz bloqueMatriz) {
		iFuncionesHabilitarCamposSrv.habilitarBloqueTextos(bloqueMatriz);
	}
	
	public void calcular() {
		listaResultados = iOperacionesMatrizSrv.calcular(cubo);
	}
	
	public Cubo getCubo() {
		return cubo;
	}
	
	public List<Integer> getListaResultados() {
		return listaResultados;
	}
}
