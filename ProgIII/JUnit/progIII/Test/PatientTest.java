package progIII.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import progIII.logic.Appointment;
import progIII.logic.Doctor;
import progIII.logic.Patient;

public class PatientTest {
	Patient p= new Patient("Pepito", "123", "pass", "micasa", "email@email.com");
	Doctor d=new Doctor("felipe", "7777778W", "contrasenya", "bilbao", "felipeIV@gmail.com");
	Appointment a= new Appointment("10/10/2020 9:50","10/10/2020 10:00","sinmotivo");
	Appointment ap= new Appointment("10/10/2020 09:50", "10/10/2020 10:00", "Cuentitis");
	Appointment app= new Appointment("10/11/2020 09:50", "10/11/2020 10:00", "Piritis");
	/*@Before
	public void setUp() throws Exception {
		Patient p= new Patient("Pepito", "123", "pass", "micasa", "email@email.com");
		Doctor d=new Doctor(777777, "felipe", "7777778W", "contrasenya", "bilbao", "felipeIV@gmail.com");
	}
	*/
	@Test
	public void checkTest() {
		d.getCalendar().add(a);
		assertEquals(false, p.checkAppointment(ap, d));
	}
	@Test
	public void CreateAppointmentTest() {
		d.getCalendar().add(a);
		p.createAppointment( app, d);
		assertEquals(app,d.getCalendar().get(1) );
		
		//assertEquals(d.getCalendar().get(arg0),d.isDisp() );
	}

}
