package progIII.logic;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {

	//private int dNumber;
	private String speciality;
	private boolean disp;
	List<Appointment> calendar ;
	// private enum especialidad{PSIQUIATRA,PEDIATRA,CARDIOLOGO,GINECOLOGO}

	public Doctor(String name, String id, String password, String address, String mail) {

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

	public void doctorDisp( Appointment a) {
		List<Appointment> c = this.getCalendar();
		this.setDisp(false);
		for (int i = 0; i<c.size(); i++) {
			if(a.getIniH().after(this.getCalendar().get(i).getFinH())) {
				this.setDisp(true);

			}
		}


	}

	// GETTERS SETTERS Y CONSTRUCTORES VARIOS

	// Constructor vac�o

	public Doctor() {

		this.setName(null);
		this.setId(null);
		this.setPassword(null);
		this.setAddress(null);
		this.setMail(null);
		this.setRol("Doctor");

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
