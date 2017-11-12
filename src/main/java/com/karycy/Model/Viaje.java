package com.karycy.Model;
import java.util.List;

import com.mongodb.BasicDBObject;

public class Viaje  {

	 private String viajeId = "";
	 private String cacheTractor = "";
	 private String consecutivoLinea="";
	 private String consecutivoTractor = "";
	 private String estatusViaje = "";
	 List<Caseta> casetas;
	 
	public String getViajeId() {
		return viajeId;
	}

	public void setViajeId(String viajeId) {
		this.viajeId = viajeId;
	}

	public String getCacheTractor() {
		return cacheTractor;
	}

	
	public String getConsecutivoLinea() {
		return consecutivoLinea;
	}

	public void setConsecutivoLinea(Object obj) {
		if(obj != null)
			this.consecutivoLinea = obj.toString();
		else
			this.consecutivoLinea = "";
	}

	public String getConsecutivoTractor() {
		return consecutivoTractor;
	}

	public void setConsecutivoTractor(Object obj) {
		if(obj != null)
			this.consecutivoTractor = obj.toString();
		else
			this.consecutivoTractor = "";
	}

	public void setCacheTractor(Object obj) {
		if(obj != null)
			this.cacheTractor = obj.toString();
		else
			this.cacheTractor = "";
	}

	public List<Caseta> getCasetas() {
		return casetas;
	}

	public void setCasetas(List<Caseta> casetas) {
		this.casetas = casetas;
	}

	public String getEstatusViaje() {
		return estatusViaje;
	}

	public void setEstatusViaje(Object obj) {
		if(obj != null)
			this.estatusViaje = obj.toString();
		else
			this.estatusViaje = "";
	}
	 
	 
}
