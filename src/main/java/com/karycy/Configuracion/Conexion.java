/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.karycy.Configuracion;


import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


public class Conexion {
	MongoClient mongo;
	DBCollection table;
	DB db;
	public  DBCollection getTablaConexion(String tabla) throws UnknownHostException{
		
		mongo = new MongoClient();
		try {
			//mongo = new MongoClient("ds133529-a0.mlab.com", 33529);
			mongo = new MongoClient(new MongoClientURI("mongodb://transporteskarycy:SA0OPQr4bw@ds133529-a0.mlab.com:33529/transportes-pro"));
			//mongo = new MongoClient(new MongoClientURI("mongodb://luisguerrero:l1u2i3s4@127.0.0.1:27017/transporteskarycy"));
			db = mongo.getDB("transportes-pro");
			//boolean auth = db.authenticate("transporteskarycy", "SA0OPQr4bw".toCharArray());
			table = db.getCollection(tabla);
			
		} catch (Exception e) {
			return null;
		}
		return table;
	}	
	public DB getDB(){
		return db;
		
	}
	
	
}
