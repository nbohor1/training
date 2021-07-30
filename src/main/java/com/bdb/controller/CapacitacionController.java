package com.bdb.controller;

import javax.net.ssl.SSLException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bdb.dao.InfoCliente;
import com.bdb.service.CapacitacionService;

@RestController
public class CapacitacionController {

	@Autowired
	private CapacitacionService service;

	@Autowired
	public CapacitacionController(CapacitacionService servicio) {
		this.service = servicio;
	}

	@GetMapping("/cliente/{tipoId}/{identificacion}")
	public InfoCliente getInfo(@RequestHeader(name = "RqUID", required = true) String RqUID,
			@RequestHeader(name = "Canal", required = true) String Canal, @PathVariable("tipoId") String TipoId,
			@PathVariable("identificacion") String identificacion) {

		InfoCliente respuesta;
		respuesta = service.getInfo(RqUID, Canal, identificacion);

		return respuesta;
	}
}
