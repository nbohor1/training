package com.bdb.backenddao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {
	 @JsonProperty("TipoIdentificacion") 
	    public String tipoIdentificacion;
	    @JsonProperty("Identificacion") 
	    public String identificacion;
	    @JsonProperty("DatosPrincipales") 
	    public DatosPrincipales datosPrincipales;
	    @JsonProperty("Cuentas") 
	    public List<Cuenta> cuentas;
}
