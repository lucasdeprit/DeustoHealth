package progIII.Test;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import progIII.logic.*;

class DoctorTest {

	private Doctor d;
	private Appointment a;
	
	
	@Before
	public void setUp() {
		d = new Doctor(777777, "felipe", "7777778W", "contrasenya", "bilbao", "felipeIV@gmail.com");
		a = new Appointment ("03/03/2010 10:00", "03/03/2010 11:08", "nose");
	}
	@Test
	void testDoctorDisp() {
		
		d.doctorDisp(d, a);
		 boolean resultado = d.isDisp();
		System.out.println(a.toString());
		assertEquals(true,resultado);
	}

}
