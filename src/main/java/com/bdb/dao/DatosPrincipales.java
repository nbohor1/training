package com.bdb.dao;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;



public class DatosPrincipales   {
  @JsonProperty("Nombre")
  private String nombre = null;

  @JsonProperty("Edad")
  private Integer edad = null;

  @JsonProperty("Saldo")
  private BigDecimal saldo = null;

  @JsonProperty("Casado")
  private Boolean casado = false;

  public DatosPrincipales nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public DatosPrincipales edad(Integer edad) {
    this.edad = edad;
    return this;
  }


  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public DatosPrincipales saldo(BigDecimal saldo) {
    this.saldo = saldo;
    return this;
  }

  

  public BigDecimal getSaldo() {
    return saldo;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }

  public DatosPrincipales casado(Boolean casado) {
    this.casado = casado;
    return this;
  }


  public Boolean isCasado() {
    return casado;
  }

  public void setCasado(Boolean casado) {
    this.casado = casado;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatosPrincipales datosPrincipales = (DatosPrincipales) o;
    return Objects.equals(this.nombre, datosPrincipales.nombre) &&
        Objects.equals(this.edad, datosPrincipales.edad) &&
        Objects.equals(this.saldo, datosPrincipales.saldo) &&
        Objects.equals(this.casado, datosPrincipales.casado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, edad, saldo, casado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatosPrincipales {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
    sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
    sb.append("    casado: ").append(toIndentedString(casado)).append("\n");
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

