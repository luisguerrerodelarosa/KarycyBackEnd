package com.karycy.Model;

public class DireccionCliente {

	String calle;
	String noExterior;
	String colonia;
	String localidad;
	String municipio;
	String estado;
	String codigoPostal;
	String idCliente;
	int direccionTipo;
	
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public int getDireccionTipo() {
		return direccionTipo;
	}
	public void setDireccionTipo(int direccionTipo) {
		this.direccionTipo = direccionTipo;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNoExterior() {
		if(noExterior == null)
			return "";
		return noExterior;
	}
	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}
	public String getColonia() {
		if(colonia == null)
			return "";
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getLocalidad() {
		if(localidad == null)
			return "";
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getMunicipio() {
		if(municipio == null)
			return "";
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		if(estado == null)
			return "";
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigoPostal() {
		if(codigoPostal == null)
			return "";
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
}
