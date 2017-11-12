package com.karycy.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;

import com.karycy.Configuracion.ConexionMySql;

public class DeleteTable {

	
	
	
	public static void eliminarTabla(){
		Statement st;
		ConexionMySql mysql = new ConexionMySql();
		try {
			 st = mysql.getConexion().createStatement();
			 st.addBatch("DELETE FROM tractor");
			 st.addBatch("DELETE FROM Viaje");
			 st.addBatch("DELETE FROM caja");
			 st.addBatch("DELETE FROM ciudad");
			 st.addBatch("DELETE FROM cliente");
			 st.addBatch("DELETE FROM direccion");
			 st.addBatch("DELETE FROM viajecaja");
			 int[] results = st.executeBatch();
		      
			 mysql.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
