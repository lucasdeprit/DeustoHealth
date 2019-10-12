package progIII.logic;

import java.util.ArrayList;
import java.util.List;
public class Patient extends User {
	List<Appointment> calendar = new ArrayList<>();

	public Patient( String name, String id, String password, String address, String mail) {
		this.setName(name);
		this.setId(id);
		this.setPassword(password);
		this.setAddress(address);
		this.setMail(mail);
		this.setRol("Patient");
	}
	//checkeo de si seria posible obtener cita cuando el paciente quiera
	public boolean checkAppointment(Appointment a,Doctor d) {
		boolean result= false;
		d.doctorDisp(a);
		if(d.isDisp()) {
			result=true;
		}
		return result;
	}

	// Creaci�n de nuevas citas
	public void createAppointment(Appointment app, Doctor d) {
		//Appointment app = new Appointment(iniH, finH, reason);
		d.doctorDisp(app);
		// si el doctor no tiene la agenda ocupada la cita se a�adir�
		if (d.isDisp()) {
			this.calendar.add(app);
			d.calendar.add(app);
		}
		

	}

	// GETTERS SETTERS Y CONSTRUCTORES VARIOS

	// Constructor vac�o

	public Patient() {

		this.setName(null);
		this.setId(null);
		this.setPassword(null);
		this.setAddress(null);
		this.setMail(null);
		this.setRol("Patient");

	}


	public List<Appointment> getCalendar() {
		return calendar;
	}

	public void setCalendar(List<Appointment> calendar) {
		this.calendar = calendar;
	}

}
