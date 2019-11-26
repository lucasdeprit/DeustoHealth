package progIII.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
	
//prueba 2 portatil lucas
	//private int number;
	private String id;
	private Date iniH, finH;
	private String reason;
	private int id_doctor, id_patient;

	public Appointment(String iniH, String finH, String reason, String id, int id_doctor, int id_patient) {
		SimpleDateFormat formatoEstablecido = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date inicio=null;
		Date fin=null;
		try {
			inicio=formatoEstablecido.parse(iniH);
			fin=formatoEstablecido.parse(finH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.id = id;
		this.iniH = inicio;
		this.finH = fin;
		this.reason = reason;
		this.id_doctor = id_doctor;
		this.id_patient = id_patient;
	}

	// M�todo que comprueba si han pasado las citas, en ese caso las a�ade al
	// expediente
	// y las elimina de la agenda del m�dico
	// tambien se puede hacer una interfaz para no repetir este m�todo en las dos
	// clases

	public void refreshAppointments() {

	}

	// GETTERS SETTERS Y CONSTRUCTORES VARIOS

	// Constructor vac�o

	public Appointment() {
		this.iniH = null;
		this.finH = null;
		this.reason = null;
		this.id_doctor = 0;
		this.id_patient = 0;
	}

	public Date getIniH() {
		return iniH;
	}

	public void setIniH(Date iniH) {
		this.iniH = iniH;
	}

	public Date getFinH() {
		return finH;
	}

	public void setFinH(Date finH) {
		this.finH = finH;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getId_doctor() {
		return id_doctor;
	}

	public void setId_doctor(int id_doctor) {
		this.id_doctor = id_doctor;
	}

	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", iniH=" + iniH + ", finH=" + finH + ", reason=" + reason + ", id_doctor="
				+ id_doctor + ", id_patient=" + id_patient + "]";
	}
	
	

	
	

	
}
