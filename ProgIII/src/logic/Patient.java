package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient extends User {

	private int nss;
	List<Appointment> calendar = new ArrayList<Appointment>();

	public Patient(int nss, String name, String id, String password, String address, String mail) {

		this.setNss(nss);
		this.setName(name);
		this.setId(id);
		this.setPassword(password);
		this.setAddress(address);
		this.setMail(mail);
		this.setRol("Patient");

	}

	// Creación de nuevas citas

	public void createAppointment(Date date, String iniH, String finH, String reason, Patient p, Doctor d) {

		Appointment app = new Appointment(date, iniH, finH, reason);

		d.doctorDisp(d, app);

		// si el doctor no tiene la agenda ocupada la cita se añadirá

		if (d.isDisp() == true) {

			p.calendar.add(app);
			d.calendar.add(app);

		}

	}

	// GETTERS SETTERS Y CONSTRUCTORES VARIOS

	public Patient(int nss) {
		super();
		this.nss = nss;
	}

	// Constructor vacío

	public Patient() {

		this.setNss(-1);
		this.setName(null);
		this.setId(null);
		this.setPassword(null);
		this.setAddress(null);
		this.setMail(null);
		this.setRol("Patient");

	}

	public int getNss() {
		return nss;
	}

	public void setNss(int nss) {
		this.nss = nss;
	}

	public List<Appointment> getCalendar() {
		return calendar;
	}

	public void setCalendar(List<Appointment> calendar) {
		this.calendar = calendar;
	}

}
