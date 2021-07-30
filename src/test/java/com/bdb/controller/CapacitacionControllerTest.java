package com.bdb.controller;

import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.bdb.dao.Cuentas;
import com.bdb.dao.DatosPrincipales;
import com.bdb.dao.InfoCliente;
import com.bdb.service.CapacitacionService;

class CapacitacionControllerTest {
	
	@Mock
	CapacitacionService servicio;
	
	@InjectMocks
	CapacitacionController controller;
	
	@BeforeEach
	void setUp()throws Exception{
		servicio = Mockito.mock(CapacitacionService.class);
		controller = new CapacitacionController(servicio);
	}

	@Test
	void test() {
		//Se crea objeto de respuesta mock
        InfoCliente infoclienteMock = new InfoCliente();

        List<Cuentas> listCuentas = new ArrayList<Cuentas>();
        Cuentas cuenta = new Cuentas("SDA", 56088);
        listCuentas.add(cuenta);

        DatosPrincipales datosPrincipales = new DatosPrincipales();
        datosPrincipales.setNombre("Cliente Prueba 1");
        datosPrincipales.setEdad(25);
        datosPrincipales.setSaldo(BigDecimal.valueOf(1000000));
        datosPrincipales.setCasado(false);

        infoclienteMock.setTipoIdentificacion("CC");
        infoclienteMock.setIdentificacion("123456");
        infoclienteMock.setDatosPrincipales(datosPrincipales);   
        infoclienteMock.setCuentas(listCuentas);
        
        Mockito.when(servicio.getInfo("111", "PB", "123456")).thenReturn(infoclienteMock);
        
        InfoCliente response = controller.getInfo("111", "PB","C", "123456");
        
        Assert.assertNotNull(response);
        Assert.assertEquals(datosPrincipales.getEdad(), response.getDatosPrincipales().getEdad());
	}

}
