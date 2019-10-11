package progIII.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import progIII.logic.*;

class DoctorTest {

	private Doctor d=new Doctor(777777, "felipe", "7777778W", "contrasenya", "bilbao", "felipeIV@gmail.com");
	private Appointment a= new Appointment("10/10/2020 09:50","10/10/2020 10:00","Cuentitis");
	private Appointment ap=new Appointment("10/10/2020 10:59", "10/10/2020 11:00 ", "Piritis");
	private Appointment app=new Appointment("10/10/2020 09:59", "10/10/2020 11:05 ", "Piritis");
	@Test
	public void testConstructor() {
		assertNotNull(d);
	}
	@Test
	public void testGetters() {
	assertNotNull(d.isDisp());
	}
	@Test
	public void testDoctorDisp() {
		
		d.getCalendar().add(a);
		d.doctorDisp(ap);
		assertEquals(true, d.isDisp());
		d.doctorDisp(app);
		assertEquals(false,d.isDisp());
	}
	@Test
	void testDoctorGetDNumber(){
		assertEquals(777777, d.getdNumber(),000001);
	}
	@Test
	void testDoctorName(){
		assertEquals("felipe",d.getName().toString());
	}
	
	

}
