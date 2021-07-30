package com.bdb.service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.net.ssl.SSLException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.bdb.WebClientConfig;
import com.bdb.backenddao.Cliente;
import com.bdb.backenddao.Cuenta;
import com.bdb.dao.Cuentas;
import com.bdb.dao.DatosPrincipales;
import com.bdb.dao.InfoCliente;

import reactor.core.publisher.Mono;

@Service
public class CapacitacionService {

	@Autowired
	private HttpServletRequest context;

	@Autowired
	WebClientConfig webClient;

	public InfoCliente getInfo(String RqUID, String canal, String identificacion) {

		InfoCliente jsonResponse = new InfoCliente();
		System.out.println("Request Client");

		System.out.println("Request Backend ");

		Mono<Cliente> response;
		try {
			response = webClient.getWebClient().get().uri(identificacion).retrieve().bodyToMono(Cliente.class);

			Cliente backendResponse = response.block();

			System.out.println("Response Backend ");

			jsonResponse.setTipoIdentificacion(backendResponse.tipoIdentificacion);
			jsonResponse.setIdentificacion(backendResponse.identificacion);
			jsonResponse.setDatosPrincipales(new DatosPrincipales());
			jsonResponse.getDatosPrincipales().setCasado(backendResponse.datosPrincipales.casado);
			jsonResponse.getDatosPrincipales().setEdad(backendResponse.datosPrincipales.edad);
			jsonResponse.getDatosPrincipales().setNombre(backendResponse.datosPrincipales.nombre);
			jsonResponse.getDatosPrincipales().setSaldo(BigDecimal.valueOf(backendResponse.datosPrincipales.saldo));
			jsonResponse.setCuentas(new ArrayList<>());

			for (Cuenta backendCuenta : backendResponse.cuentas) {
				Cuentas ctas = new Cuentas(backendCuenta.tipo, Integer.valueOf(backendCuenta.numero));
				jsonResponse.getCuentas().add(ctas);
			}

			System.out.println("Response Client");
		} catch (SSLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonResponse;
	}

}
