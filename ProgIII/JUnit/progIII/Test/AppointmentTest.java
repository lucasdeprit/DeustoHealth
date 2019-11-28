package progIII.Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import progIII.logic.Appointment;

public class AppointmentTest {
	
	private Appointment a1;
	private Appointment a2;

	@Before
	public void setUp(){
		a1 = new Appointment();
		a2 = new Appointment("10/10/2019 09:54", "10/10/2019 11:08", "molestias en la cadera", "",1,1);
	}

	@Test
	public void testGetIniH() {
		SimpleDateFormat formatoEstablecido = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String iniH = "Thu Oct 10 09:54:00 CEST 2019";
		Date inicio;
		try {
			inicio = formatoEstablecido.parse(iniH);
			System.out.println(inicio);
			assertEquals(inicio, a2.getIniH());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testConstructorVacio() {
		//Probamos el constructor vacio funciona
		assertEquals(null, a1.getIniH());
		assertEquals(null, a1.getFinH());
		assertEquals(null, a1.getReason());
		
	}
	@Test
	public void testConstructorNoVacio() {
		//Probamos contructor funciona
		SimpleDateFormat formatoEstablecido = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date inicio=null;
		Date fin=null;
		try {
			inicio=formatoEstablecido.parse("10/10/2019 09:54");
			fin=formatoEstablecido.parse("10/10/2019 11:08");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//Probamos contructor con valores
		assertEquals(inicio, a2.getIniH());
		assertEquals(fin, a2.getFinH());
		assertEquals("molestias en la cadera", a2.getReason());
	}

}
