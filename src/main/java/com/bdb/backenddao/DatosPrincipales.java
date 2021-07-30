package com.bdb.backenddao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatosPrincipales {
	   @JsonProperty("Nombre") 
	    public String nombre;
	    @JsonProperty("Edad") 
	    public int edad;
	    @JsonProperty("Saldo") 
	    public int saldo;
	    @JsonProperty("Casado") 
	    public boolean casado;
}
