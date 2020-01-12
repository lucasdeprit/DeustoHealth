package progIII.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import progIII.bd.SqliteDatabase;
import progIII.logic.LoginCorrecto;

public class SqliteDatabaseTest {

	@Test
	public void test() throws SQLException {
		Connection conn ;
		
		conn=SqliteDatabase.initBD("Usuarios");
		
		LoginCorrecto log = new LoginCorrecto("lucas", "lucas", conn, true);
	
		assertEquals(true, log.isTrue());
		SqliteDatabase.cerrarBD(conn);
		
	}

}
