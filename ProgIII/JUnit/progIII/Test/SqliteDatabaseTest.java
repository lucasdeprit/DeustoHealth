package progIII.Test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import progIII.bd.SqliteDatabase;
import progIII.logic.LoginCorrecto;

public class SqliteDatabaseTest {

	@Test
	public void test() {
		Connection conn ;
		
		conn=SqliteDatabase.initBD("Usuarios");
		
		LoginCorrecto log = new LoginCorrecto("", "progggramacion", conn, false);
	
		assertEquals(true, log.isTrue());
		SqliteDatabase.cerrarBD(conn);
		
	}

}
