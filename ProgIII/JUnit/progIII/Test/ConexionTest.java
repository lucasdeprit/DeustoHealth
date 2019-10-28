package progIII.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOError;

import org.junit.Test;

import bd.Conexion;
import progIII.logic.Patient;

public class ConexionTest {
File bd=new File("JUnit/Bdtest/bdTest.test");
Conexion c= new Conexion(bd);
Patient p= new Patient("Pepito", "123", "pass", "micasa", "email@email.com");
	@Test
	public void getRutatest() {
		System.out.println(c.getRuta());
		assertEquals(bd.getPath(), c.getRuta());
		
		
	}
	@Test
	public void Existe() {
		assertEquals(true, bd.exists());
	}
	@Test
	public void  insertTest() {
	c.abrir();
	c.insertPatient(p);
	System.out.println(bd.getName());
	assertEquals("123", c.ReturnBdinList().getFirst().getId());
	bd.deleteOnExit();
	c.cerrar();
		}	
}

