package progIII.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import progIII.bd.SqliteDatabase;

public class LoginCorrecto {
String nombre;
String pass;
Connection con;
boolean paciente;
public String getNombre() {
	return nombre;
}
public String getPass() {
	return pass;
}

public LoginCorrecto(String nombre, String pass, Connection conn,boolean b) {
	// TODO Auto-generated constructor stub
	this.nombre = nombre;
	this.pass = pass;
	this.con=conn;
	this.paciente=b;
}
public boolean isTrue() throws SQLException {
	boolean result = false;
	SqliteDatabase.usarCrearTablasBD(this.con);
	if(this.paciente) {
		String sql ="select * from patient where name ="+this.nombre+" and password ="+this.pass;
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			this.nombre.equals(rs.getString(2));
			this.pass.equals(rs.getString(3));
		}
		
	}if(!this.paciente) {
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM doctor WHERE name=? AND password=?");) 
		{pst.setString(1, nombre);
		pst.setString(2, pass);
		pst.executeQuery();
		result=true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("No aparece en la db");
			result=false;
		}
		
	}
	return result;
}
public boolean paciente() {
	return true;
}
}
