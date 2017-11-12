package com.karycy.Model;

public class Cliente {

	private String _id;
	private String email;
	private String estado;
	private String nombre;
	private String razonSocial;
	private String rfc;
	private DireccionCliente direccionFiscal;
	public void set_id(String _id) {
		this._id = _id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public void setDireccionFiscal(DireccionCliente direccionFiscal) {
		this.direccionFiscal = direccionFiscal;
	}
	public String get_id() {
		if(_id == null)
			return "";
		return _id;
	}
	public String getEmail() {
		if(email == null)
			return "";
		return email;
	}
	public String getEstado() {
		if(estado == null)
			return "";
		return estado;
	}
	public String getNombre() {
		if(nombre == null)
			return "";
		return nombre;
	}
	public String getRazonSocial() {
		if(razonSocial == null)
			return "";
		return razonSocial;
	}
	public String getRfc() {
		if(rfc == null)
			return "";
		return rfc;
	}
	public DireccionCliente getDireccionFiscal() {
		return direccionFiscal;
	}
	
	
}
