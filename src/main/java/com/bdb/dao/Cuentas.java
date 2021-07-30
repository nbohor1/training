package com.bdb.dao;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Cuentas   {
  @JsonProperty("numero")
  private Integer numero = null;

  @JsonProperty("tipo")
  private String tipo = null;

  public Cuentas numero(Integer numero) {
    this.numero = numero;
    return this;
  }


  public Cuentas(String tipo,  Integer numero) {
	super();
	this.numero = numero;
	this.tipo = tipo;
}



public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Cuentas tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

 
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cuentas cuentas = (Cuentas) o;
    return Objects.equals(this.numero, cuentas.numero) &&
        Objects.equals(this.tipo, cuentas.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numero, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cuentas {\n");
    
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

