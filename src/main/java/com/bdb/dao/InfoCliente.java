package com.bdb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class InfoCliente   {
  @JsonProperty("TipoIdentificacion")
  private String tipoIdentificacion = null;

  @JsonProperty("Identificacion")
  private String identificacion = null;

  @JsonProperty("DatosPrincipales")
  private DatosPrincipales datosPrincipales = null;

  @JsonProperty("Cuentas")
  private List<Cuentas> cuentas = null;

  public InfoCliente tipoIdentificacion(String tipoIdentificacion) {
    this.tipoIdentificacion = tipoIdentificacion;
    return this;
  }


  public String getTipoIdentificacion() {
    return tipoIdentificacion;
  }

  public void setTipoIdentificacion(String tipoIdentificacion) {
    this.tipoIdentificacion = tipoIdentificacion;
  }

  public InfoCliente identificacion(String identificacion) {
    this.identificacion = identificacion;
    return this;
  }



  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public InfoCliente datosPrincipales(DatosPrincipales datosPrincipales) {
    this.datosPrincipales = datosPrincipales;
    return this;
  }


  public DatosPrincipales getDatosPrincipales() {
    return datosPrincipales;
  }

  public void setDatosPrincipales(DatosPrincipales datosPrincipales) {
    this.datosPrincipales = datosPrincipales;
  }

  public InfoCliente cuentas(List<Cuentas> cuentas) {
    this.cuentas = cuentas;
    return this;
  }

  public InfoCliente addCuentasItem(Cuentas cuentasItem) {
    if (this.cuentas == null) {
      this.cuentas = new ArrayList<Cuentas>();
    }
    this.cuentas.add(cuentasItem);
    return this;
  }

 

  public List<Cuentas> getCuentas() {
    return cuentas;
  }

  public void setCuentas(List<Cuentas> cuentas) {
    this.cuentas = cuentas;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfoCliente infoCliente = (InfoCliente) o;
    return Objects.equals(this.tipoIdentificacion, infoCliente.tipoIdentificacion) &&
        Objects.equals(this.identificacion, infoCliente.identificacion) &&
        Objects.equals(this.datosPrincipales, infoCliente.datosPrincipales) &&
        Objects.equals(this.cuentas, infoCliente.cuentas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoIdentificacion, identificacion, datosPrincipales, cuentas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfoCliente {\n");
    
    sb.append("    tipoIdentificacion: ").append(toIndentedString(tipoIdentificacion)).append("\n");
    sb.append("    identificacion: ").append(toIndentedString(identificacion)).append("\n");
    sb.append("    datosPrincipales: ").append(toIndentedString(datosPrincipales)).append("\n");
    sb.append("    cuentas: ").append(toIndentedString(cuentas)).append("\n");
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

