package progIII.Test;
import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import bd.Conexion;
import progIII.logic.Patient;
public class ConexionTest {
File bd=new File("JUnit/Bdtest/bdTest.test");
ODB odb ;//= ODBFactory.open(bd.getPath());
Conexion c= new Conexion(bd,odb);
Patient p= new Patient("Pepito", "123", "pass", "micasa", "email@email.com");
	@Test
	public void getRutatest() {
		assertEquals(bd.getPath(), c.getRuta());}
	@Test
	public void Existe() {
		ODB odb1 = ODBFactory.open(this.bd.getPath());
		c.setOdb(odb1);
		assertEquals(true, bd.exists());
		c.cerrar();
	}
	@Test
	public void  insertTest() {
	ODB odb1 = ODBFactory.open(this.bd.getPath());
	c.setOdb(odb1);
	c.insertPatient(p);
	System.out.println(bd.getName());
	assertEquals("123", c.ReturnBdinList().getFirst().getId());
	bd.deleteOnExit();
	c.cerrar();
		}
}

