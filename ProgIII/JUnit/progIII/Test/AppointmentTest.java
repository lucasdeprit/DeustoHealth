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
		a2 = new Appointment("10/10/2019 09:54", "10/10/2019 11:08", "molestias en la cadera");
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

}
