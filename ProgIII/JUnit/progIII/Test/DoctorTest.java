package progIII.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

import progIII.logic.*;

class DoctorTest {

	private Doctor d=new Doctor("felipe", "7777778W", "contrasenya", "bilbao", "felipeIV@gmail.com");
	private Appointment a= new Appointment("10/10/2020 09:50","10/10/2020 10:00","Cuentitis","a1",1,1);
	private Appointment ap=new Appointment("10/10/2020 10:59", "10/10/2020 11:00 ", "Piritis","a2",2,2);
	private Appointment app=new Appointment("10/10/2020 09:59", "10/10/2020 11:05 ", "Piritis","a3",3,3);
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
	void testDoctorName(){
		assertEquals("felipe",d.getName().toString());
	}
	
	

}
