package progIII.Test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import bd.Conexion;
import progIII.logic.Patient;

public class ConexionTest {
File bd=new File("JUnit/Bdtest/bdTest.test");
Conexion c= new Conexion(bd);
Patient p= new Patient("Pepito", "123", "pass", "micasa", "email@email.com");
	@Test
	public void getRutatest() {
		assertEquals(bd.getPath(), c.getRuta());
		assertEquals(true, bd.exists());
		
	}
	@Test
	public void  insertTest() {
	
	if (bd.exists()) {
		c.insertPatient(p);
	}
	System.out.println(c.ReturnBdinList().getFirst().getName());
	assertEquals(p, c.ReturnBdinList().getFirst());
		//c.insertPatient(p);
	}

}
