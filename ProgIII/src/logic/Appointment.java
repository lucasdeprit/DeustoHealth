package logic;

import java.util.Date;

public class Appointment {
	
//prueba 2 portatil lucas

	private Date date;
	private String iniH, finH;
	private String reason;

	public Appointment(Date date, String iniH, String finH, String reason) {
		this.date = date;
		this.iniH = iniH;
		this.finH = finH;
		this.reason = reason;
	}

	// Método que comprueba si han pasado las citas, en ese caso las añade al
	// expediente
	// y las elimina de la agenda del médico
	// tambien se puede hacer una interfaz para no repetir este método en las dos
	// clases

	public void refreshAppointments() {

	}

	// GETTERS SETTERS Y CONSTRUCTORES VARIOS

	// Constructor vacío

	public Appointment() {

		this.date = null;
		this.iniH = null;
		this.finH = null;
		this.reason = null;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIniH() {
		return iniH;
	}

	public void setIniH(String iniH) {
		this.iniH = iniH;
	}

	public String getFinH() {
		return finH;
	}

	public void setFinH(String finH) {
		this.finH = finH;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
