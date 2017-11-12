package com.karycy.Service;


import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.karycy.Configuracion.Conexion;
import com.karycy.Configuracion.ConexionMySql;
import com.karycy.Model.Caseta;
import com.karycy.Model.DireccionCliente;
import com.karycy.Model.Tractor;
import com.karycy.Model.Viaje;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;


@RestController
public class KarycyService {

	PreparedStatement preparedStatement;
	private ConexionMySql mysql;
	private Conexion conexion = new Conexion();
	@RequestMapping("/testApp")
	public String welcome() {//Welcome page, non-rest
		ArrayList<Tractor> tractores;
		DeleteTable.eliminarTabla();
		getViajeGasto();
		//getViajeCaja();
		//getCliente();
		//getCaja();
		//getCiudad();
		//getTractores();
		//getViajes();
		return "Welcome to RestTemplate Example.";
	}
	
	@RequestMapping(value = "/test/{test}", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody   Object welcome(@PathVariable String test ) {//Welcome page, non-rest
		List<String> lista = new ArrayList<String>();
		
		lista.add("1");
		lista.add("2");
		lista.add("Welcome to RestTemplate Example");
		return lista;
	}

	@RequestMapping(value = "/ListaCasetas/{fechaInicio}/{fechaFin}", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody Object message(@PathVariable String fechaInicio,@PathVariable String fechaFin) {//REST Endpoint.
		List<String> test = new ArrayList<String>();
		
		test.add("1");
		test.add("2");
		test.add("3");
		//String fechaInicio="2017-10-01";
		//String fechaFin = "2017-10-09";
		//return test;
		return null;
	}


	

	public ArrayList<Tractor> getCaja(){
		DBCollection table;
		
		mysql = new ConexionMySql();
		String query=" INSERT INTO caja("
				+ "idCaja,ano,estatus,idLinea,marca,"
				+ "modelo,numero,placas,tipo,tipoDeCaja)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
		String inserts="";
		try {
			preparedStatement =mysql.getConexion().prepareStatement(query);
			table = conexion.getTablaConexion("Caja");
			if(table != null){
				BasicDBObject searchQuery = new BasicDBObject();

				DBCursor cursor = table.find(searchQuery);
				
				while (cursor.hasNext()) {
					//tractor = new Tractor();
					BasicDBObject obj = (BasicDBObject) cursor.next();
					preparedStatement.setString(1, validate(obj.get("_id")));
					preparedStatement.setString(2, validate(obj.get("ano")));
					preparedStatement.setString(3, validate(obj.get("estado")));
					preparedStatement.setString(4, validate(obj.get("lineaId")));
					preparedStatement.setString(5, validate(obj.get("marca")));
					preparedStatement.setString(6, validate(obj.get("modelo")));
					preparedStatement.setString(7, validate(obj.get("numero")));
					preparedStatement.setString(8, validate(obj.get("placas")));
					preparedStatement.setString(9, validate(obj.get("tipo")));
					preparedStatement.setString(10, validate(obj.get("tipoDeCaja")));

					preparedStatement.addBatch();
				}
				int[] results = preparedStatement.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return null;
		
	}
	

	public ArrayList<Tractor> getTractores(){
		DBCollection table;
		ArrayList<Tractor> tractores = new ArrayList<Tractor>();
		//Tractor tractor;
		 mysql = new ConexionMySql();
		String query=" INSERT INTO Tractor(id,ano,estado,idUnidadGPS,lineaId,marca,modelo,numero,"
				+ "placas,tipo,tipoDeCaja,slack,tagId)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String inserts="";
		try {
			preparedStatement =mysql.getConexion().prepareStatement(query);
			table = conexion.getTablaConexion("Tractor");
			if(table != null){
				BasicDBObject searchQuery = new BasicDBObject();
				//searchQuery.put("estado", "Activo");
				//searchQuery.put("numero", "TA029");
				searchQuery.put("tipo", "Tractor");
				
				DBCursor cursor = table.find(searchQuery);
				
				while (cursor.hasNext()) {
					//tractor = new Tractor();
					BasicDBObject obj = (BasicDBObject) cursor.next();
					preparedStatement.setString(1, validate(obj.get("_id")));
					preparedStatement.setString(2, validate(obj.get("ano")));
					preparedStatement.setString(3, validate(obj.get("estado")));
					preparedStatement.setString(4, validate(obj.get("idUnidadGPS")));
					preparedStatement.setString(5, validate(obj.get("lineaId")));
					preparedStatement.setString(6, validate(obj.get("marca")));
					preparedStatement.setString(7, validate(obj.get("modelo")));
					preparedStatement.setString(8, validate(obj.get("numero")));
					preparedStatement.setString(9, validate(obj.get("placas")));
					preparedStatement.setString(10, validate(obj.get("tipo")));
					preparedStatement.setString(11, validate(obj.get("tipoDeCaja")));
					preparedStatement.setString(12, validate(obj.get("slackWebhook")));
					preparedStatement.setString(13, validate(obj.get("tagId")));
					preparedStatement.addBatch();
					//tractor.setNumeroTractor(obj.get("numero").toString());
					//tractor.setTagId(obj.get("tagId"));
					//tractores.add(tractor);
				}
				int[] results = preparedStatement.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return tractores;
		
	}
	public ArrayList<Tractor> getViajes(){
		DBCollection table;
		ArrayList<Tractor> tractores = new ArrayList<Tractor>();
		//Tractor tractor;
		mysql = new ConexionMySql();
		String query=" INSERT INTO viaje"
				+ "(idViaje,idLinea,numeroViajeLinea,nombreLinea,idTractor,"
				+ " nombreTractor,numeroViajeTractor,idOperador,nombreOperador,cajasViaje,"
				+ " estatusViaje,fechaSalidaViaje,fechaSalidaTanque,kmsInicioOdometro,"
				+ " fechaLlegadaViaje,fechaLlegadaTanque,kmsFinOdometro,bloqueado"
				+ ")"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String inserts="";
		try {
			preparedStatement =mysql.getConexion().prepareStatement(query);
			table = conexion.getTablaConexion("Viaje");
			if(table != null){
				BasicDBObject searchQuery = new BasicDBObject();
				//searchQuery.put("cacheTractor", "TK020");
				//searchQuery.put("consecutivoTractor", 75);
				//searchQuery.put("tipo", "Tractor");
				
				DBCursor cursor = table.find(searchQuery);
				
				while (cursor.hasNext()) {
					//tractor = new Tractor();
					BasicDBObject obj = (BasicDBObject) cursor.next();
					preparedStatement.setString(1, validate(obj.get("_id")));
					preparedStatement.setString(2, validate(obj.get("lineaId")));
					preparedStatement.setInt(3, validateInt(obj.getInt("consecutivoLinea")));
					preparedStatement.setString(4, validate(obj.get("cacheLinea")));
					preparedStatement.setString(5, validate(obj.get("tractorId")));
					preparedStatement.setString(6, validate(obj.get("cacheTractor")));
					preparedStatement.setInt(7, validateInt(obj.getInt("consecutivoTractor")));
					preparedStatement.setString(8, validate(obj.get("operadorId")));
					preparedStatement.setString(9, validate(obj.get("cacheOperador")));
					preparedStatement.setString(10, validate(obj.get("cacheCajas")));
					preparedStatement.setString(11, validate(obj.get("estado")));
					preparedStatement.setTimestamp(12, construirFecha(obj.getDate("salida"), obj.get("horaSalida")));
					preparedStatement.setTimestamp(13, construirFecha(obj.getDate("salidaTanques"), obj.get("horaSalidaTanques")));
					preparedStatement.setBigDecimal(14, validateDecimal(obj.get("kmInicioOdo")));
					preparedStatement.setTimestamp(15, construirFecha(obj.getDate("llegada"), obj.get("horaLlegada")));
					preparedStatement.setTimestamp(16,construirFecha(obj.getDate("llegadaTanques"), obj.get("horaLlegadaTanques")));
					preparedStatement.setBigDecimal(17, validateDecimal(obj.get("kmFinOdo")));
					preparedStatement.setInt(18, validateBoolean(obj.getBoolean("bloqueado")));
					preparedStatement.addBatch();
					//tractor.setNumeroTractor(obj.get("numero").toString());
					//tractor.setTagId(obj.get("tagId"));
					//tractores.add(tractor);
				}
				int[] results = preparedStatement.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return tractores;
		
	}
	
	public ArrayList<Tractor> getCiudad(){

		DBCollection table;
		
		mysql = new ConexionMySql();
		String query=" INSERT INTO ciudad(idCiudad,nombreCiudad,estadoCiudad)"
				+ " VALUES(?,?,?)";
		String inserts="";
		try {
			preparedStatement =mysql.getConexion().prepareStatement(query);
			table = conexion.getTablaConexion("Ciudad");
			if(table != null){
				BasicDBObject searchQuery = new BasicDBObject();

				DBCursor cursor = table.find(searchQuery);
				
				while (cursor.hasNext()) {
					//tractor = new Tractor();
					BasicDBObject obj = (BasicDBObject) cursor.next();
					preparedStatement.setString(1, validate(obj.get("_id")));
					preparedStatement.setString(2, validate(obj.get("nombre")));
					preparedStatement.setString(3, validate(obj.get("estado")));

					preparedStatement.addBatch();
				}
				int[] results = preparedStatement.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return null;
		
	}

	public ArrayList<Tractor> getCliente(){
		DBCollection table;
		
		mysql = new ConexionMySql();
		String query=" INSERT INTO cliente("
				+ "idcliente,email,estatus,nombre,razonSocial,"
				+ "rfc)"
				+ " VALUES(?,?,?,?,?,?)";
		String inserts="";
		Gson gson = new Gson();
		ArrayList<DireccionCliente> direccion = new ArrayList<>();
		try {
			preparedStatement =mysql.getConexion().prepareStatement(query);
			table = conexion.getTablaConexion("Cliente");
			if(table != null){
				BasicDBObject searchQuery = new BasicDBObject();

				DBCursor cursor = table.find(searchQuery);
				int x=0;
				while (cursor.hasNext()) {
					//tractor = new Tractor();
					BasicDBObject obj = (BasicDBObject) cursor.next();
					String cadena="";
					
					preparedStatement.setString(1, validate(obj.get("_id")));
					preparedStatement.setString(2, validate(obj.get("email")));
					preparedStatement.setString(3, validate(obj.get("estado")));
					preparedStatement.setString(4, validate(obj.get("nombre")));
					preparedStatement.setString(5, validate(obj.get("razonSocial")));
					preparedStatement.setString(6, validate(obj.get("rfc")));
					preparedStatement.addBatch();
					
					Object objx = obj.get("direccion");
					DireccionCliente dir = new DireccionCliente();
					if(objx !=null && !objx.toString().trim().equals("")){
						try {
							dir = gson.fromJson(objx.toString(), DireccionCliente.class);  
						} catch (Exception e) {
							dir = null;
						}
						if(dir != null ){
							dir.setIdCliente(validate(obj.get("_id")));
							dir.setDireccionTipo(1);
							direccion.add(dir);
						}
					}
					objx = obj.get("direccionFiscal");
					if(objx !=null && !objx.toString().trim().equals("")){
						gson = new Gson();
						dir = new DireccionCliente();
						try {
							dir = gson.fromJson(objx.toString(), DireccionCliente.class);  
						} catch (Exception e) {
							dir = null;
						}
						if(dir != null ){
							dir.setIdCliente(validate(obj.get("_id")));
							dir.setDireccionTipo(2);
							direccion.add(dir);
						}
					}	
				}
				int[] results = preparedStatement.executeBatch();
				query=" INSERT INTO direccion("
						+ "calle,noExterior,colonia,localidad,municipio,"
						+ "estado,codigoPostal,direccionTipo,idCliente)"
						+ " VALUES(?,?,?,?,?,?,?,?,?)";
				preparedStatement =mysql.getConexion().prepareStatement(query);
				for(int i=0;i<direccion.size();i++){
					DireccionCliente dir = direccion.get(i);
					preparedStatement.setString(1, validate(dir.getCalle()));
					preparedStatement.setString(2, validate(dir.getNoExterior()));
					preparedStatement.setString(3, validate(dir.getColonia()));
					preparedStatement.setString(4, validate(dir.getLocalidad()));
					preparedStatement.setString(5, validate(dir.getMunicipio()));
					preparedStatement.setString(6, validate(dir.getEstado()));
					preparedStatement.setString(7, validate(dir.getCodigoPostal()));
					preparedStatement.setInt(8, validateInt(dir.getDireccionTipo()));
					preparedStatement.setString(9, validate(dir.getIdCliente()));
					preparedStatement.addBatch();
				}
				results = preparedStatement.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return null;
		
	}
	
	
	public ArrayList<Tractor> getViajeCaja(){

		DBCollection table;
		
		mysql = new ConexionMySql();
		String query=" INSERT INTO viajecaja(idViajeCaja,idViaje,idCaja)"
				+ " VALUES(?,?,?)";
		String inserts="";
		try {
			preparedStatement =mysql.getConexion().prepareStatement(query);
			table = conexion.getTablaConexion("ViajeCaja");
			if(table != null){
				BasicDBObject searchQuery = new BasicDBObject();

				DBCursor cursor = table.find(searchQuery);
				
				while (cursor.hasNext()) {
					//tractor = new Tractor();
					BasicDBObject obj = (BasicDBObject) cursor.next();
					preparedStatement.setString(1, validate(obj.get("_id")));
					preparedStatement.setString(2, validate(obj.get("viajeId")));
					preparedStatement.setString(3, validate(obj.get("cajaId")));

					preparedStatement.addBatch();
				}
				int[] results = preparedStatement.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return null;
		
	}
	
	
	public ArrayList<Tractor> getViajeGasto(){

		DBCollection table;
		
		mysql = new ConexionMySql();
		String query=" INSERT INTO viajegasto("
				+ "idViajeGasto,fecha,concepto,isFuel,litros"
				+ ",importe,iva,monto,idViaje"
				+ ",tipo,nombreCaseta"
				+ ")"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String inserts="";
		int[] results ;
		try {
			preparedStatement =mysql.getConexion().prepareStatement(query);
			table = conexion.getTablaConexion("ViajeGasto");
			if(table != null){
				BasicDBObject searchQuery = new BasicDBObject();

				DBCursor cursor = table.find(searchQuery);
				
				while (cursor.hasNext()) {
					//tractor = new Tractor();
					BasicDBObject obj = (BasicDBObject) cursor.next();
					preparedStatement.setString(1, validate(obj.get("_id")));
					preparedStatement.setTimestamp(2, getFecha(obj.getDate("fecha")));
					preparedStatement.setString(3, validate(obj.get("concepto")));
					preparedStatement.setInt(4, validateBoolean(obj.getBoolean("isFuel")));
					preparedStatement.setInt(5, validateInt(obj.get("litros")));
					preparedStatement.setBigDecimal(6, validateDecimal(obj.get("importe")));
					preparedStatement.setBigDecimal(7, validateDecimal(obj.get("iva")));
					preparedStatement.setBigDecimal(8, validateDecimal(obj.get("monto")));
					preparedStatement.setString(9, validate(obj.get("viajeId")));
					preparedStatement.setString(10, validate(obj.get("tipo")));
					preparedStatement.setString(11, validate(obj.get("nombreCaseta")));

					preparedStatement.addBatch();
				}
				results = preparedStatement.executeBatch();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			close();
		}
		return null;
		
	}	
	public BigDecimal validateDecimal(Object decimal){
		BigDecimal dec;
		try {
			if(decimal == null)
				dec = null;
			else
				 dec = new BigDecimal(decimal.toString());
		} catch (Exception e) {
			return null;
		}
		return dec;
		
	}
	public int validateBoolean(boolean estatus){
		try {
			if(estatus)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			return 0;
		}
		
		
	}
	public String validate(Object value){
		if(value == null){
			return "";
		}else{
			return value.toString().trim();
		}
	}
	public int validateInt(Object value){
		int aux=0;
		try {
			aux = Integer.parseInt(value.toString());
		} catch (Exception e) {
			return 0;
		}
		return aux;
	}
	public Timestamp getFecha(Date valueFecha){
		Timestamp timestamp = null;
		
		try {
			if(valueFecha == null)
				return null;
			timestamp = new Timestamp(valueFecha.getTime());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return timestamp;
	}
	public Timestamp construirFecha(Date valueFecha,Object valueHora){
		SimpleDateFormat formatoSimple = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatoCompleto = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fechaSimple,fechaTotal;
		java.sql.Date fecha = null;
		Date fechaAux = null;
		Timestamp timestamp = null;
		try {
			if(valueFecha == null)
				return null;
			fechaSimple = formatoSimple.format(valueFecha);
			if(valueHora == null)
				fechaTotal= fechaSimple+" 00:00";
			else
				fechaTotal= fechaSimple+" "+valueHora.toString();
			fechaAux = formatoCompleto.parse(fechaTotal);
			timestamp = new Timestamp(fechaAux.getTime());
			//fecha = new java.sql.Date(fechaAux.getTime());
		} catch (Exception e) {
			return null;
		}
		return timestamp;
	}
	
	private void close() {
        try {
        	/*
            if (resultSet != null) {
                resultSet.close();
            }
*/
            if (preparedStatement != null) {
            	preparedStatement.close();
            }

            if (mysql.getConexion() != null) {
            	mysql.getConexion().close();
            }
            if(conexion.getDB() != null){
            	conexion.getDB().getMongo().close();
            }
        } catch (Exception e) {

        }
    }
	
}
