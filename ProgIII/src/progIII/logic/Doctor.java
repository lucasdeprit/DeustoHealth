package progIII.logic;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {

	private int dNumber;
	private String speciality;
	private boolean disp;
	List<Appointment> calendar ;
	// private enum especialidad{PSIQUIATRA,PEDIATRA,CARDIOLOGO,GINECOLOGO}

	public Doctor(int dNumber) {
		super();
		this.setdNumber(dNumber);
	}

	public Doctor(int number, String name, String id, String password, String address, String mail) {

		this.setdNumber(number);
		this.setName(name);
		this.setId(id);
		this.setPassword(password);
		this.setAddress(address);
		this.setMail(mail);
		this.setRol("Doctor");
		this.disp=false;
		this.calendar= new ArrayList<>();

	}

	// Mira a ver si el doctor tiene la agenda ocupada
	//Metodo Por mejorar la cita podria ser un minuto antes y pasaria el "filtro" haciendo que un doctor tuviese a dos pacientes juntos
	public void doctorDisp( Appointment a) {
		List<Appointment> c = this.getCalendar();
		for (int i = 0; i<c.size(); i++) {

			if (c.get(i).getIniH().equals(a.getIniH())) {

				this.setDisp(false);

			}

		}
		this.setDisp(true);

	}

	// GETTERS SETTERS Y CONSTRUCTORES VARIOS

	// Constructor vac�o
	
	public Doctor() {

		this.setdNumber(-1);
		this.setName(null);
		this.setId(null);
		this.setPassword(null);
		this.setAddress(null);
		this.setMail(null);
		this.setRol("Doctor");

	}

	public int getdNumber() {
		return dNumber;
	}

	public void setdNumber(int dNumber) {
		this.dNumber = dNumber;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public boolean isDisp() {
		return disp;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}
	

	public List<Appointment> getCalendar() {
		return calendar;
	}

	public void setCalendar(List<Appointment> calendar) {	
		this.calendar = calendar;
	}

}
