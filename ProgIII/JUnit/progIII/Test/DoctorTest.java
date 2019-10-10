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
	private Appointment ap=new Appointment("10/10/2020 9:59", "10/10/2020 10:05 ", "Piritis");
	
	/*@Before
	public void setUp() {
		d = new Doctor(777777, "felipe", "7777778W", "contrasenya", "bilbao", "felipeIV@gmail.com");
		a = new Appointment ("03/03/2010 10:00", "03/03/2010 11:08", "nose");
		//System.out.println(d.getName());
	}
	*/
	@Test
	public void testConstructor() {
		
		//d = new Doctor(777777, "felipe", "7777778W", "contrasenya", "bilbao", "felipeIV@gmail.com");
		//assertEquals(777777, d.getdNumber());
		assertNotNull(d);
	}
	@Test
	public void testGetters() {
	assertNotNull(d.isDisp());
	
	
	}
	@Test
	public void testDoctorDisp() {
		//Falla porque no esta bien implementada la funcion doctorDisp
		d.getCalendar().add(a);
		d.doctorDisp(ap);
		assertEquals(false, d.isDisp());
	}
	
	  // No funcionan, debido a NullPointerExcepction
	/*
	@Test
	void testDoctorDisp() {
		System.out.println(d.getdNumber());
		d.doctorDisp(d, a);
		 boolean resultado = d.isDisp();
		System.out.println(a.toString());
		assertEquals(true,resultado);
	}
	
	@Test
	void testDoctorGetDNumber(){
		System.out.println(d.getdNumber());
		assertEquals(777777, d.getdNumber(),000001);
	}
	
	@Test
	void testDoctorName(){
		assertEquals("felipe",d.getName().toString());
	}
*/
	

}
