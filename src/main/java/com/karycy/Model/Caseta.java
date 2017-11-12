package com.karycy.Model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Caseta {

	private  String fechaCaseta = "";
	private  String subTotalCaseta = "";
	private  String ivaCaseta ="";
	private  String totalCaseta ="";
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	public String getFechaCaseta() {
		return fechaCaseta;
	}
	public void setFechaCaseta(Object object) {
		
		if(object != null){
			this.fechaCaseta = object.toString();
			Date d = (Date) object;
			this.fechaCaseta = formato.format(d);
		}
		else
			this.fechaCaseta = "";
	}
	public String getSubTotalCaseta() {
		return subTotalCaseta;
	}
	public void setSubTotalCaseta(Object object) {
		if(object != null)
			this.subTotalCaseta = object.toString();
		else
			this.subTotalCaseta = "";
	}
	public String getIvaCaseta() {
		return ivaCaseta;
	}
	public void setIvaCaseta(Object object) {
		if(object != null)
			this.ivaCaseta = object.toString();
		else
			this.ivaCaseta = "";
	}
	public String getTotalCaseta() {
		return totalCaseta;
	}
	public void setTotalCaseta(Object object) {
		if(object != null)
			this.totalCaseta = object.toString();
		else
			this.totalCaseta = "";
	}
	
	
}
