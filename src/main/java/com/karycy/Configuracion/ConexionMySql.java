package com.karycy.Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConexionMySql {

	Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    //String url = "jdbc:mysql://localhost:3307/transportes";
    String url = "jdbc:mysql://www.neroapps.com:3306/neroapps_transportes";
    String user = "neroa_admin";
    String password = "l1u2i3s4";
    
    public ConexionMySql(){
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/transportes", "root", "");
			//con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
    }
    public Connection getConexion(){
    	return  con;
    	
    }
}
