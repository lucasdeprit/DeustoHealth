package progIII.bd;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import progIII.logic.Appointment;
import progIII.logic.Doctor;
import progIII.logic.Patient;

public class SqliteDatabase {

	/** Inicializa una BD SQLITE y devuelve una conexion con ella
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexion con la base de datos indicada. Si hay algun error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:data/" + nombreBD );
			log( Level.INFO, "Conectada base de datos " + nombreBD, null );
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			log( Level.SEVERE, "Error en conexion de base de datos " + nombreBD, e );
			return null;
		}
	}

	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual. Devuelve un statement para trabajar con esa base de datos
	 * @param con	Conexion ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table patient " +
						"(id INTEGER PRIMARY KEY AUTOINCREMENT " +           // Codigo identificacion del paciente
						",name string " +         //  Nombre del paciente 
						", password string" + 	  // Contrase�a del paciente
						", address string" +	  // Direcci�n de residencia del paciente
						", mail string" +		  // Correo electr�nico del paciente
						")");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table doctor " +
						"(id INTEGER PRIMARY KEY AUTOINCREMENT" +		  // Codigo identificacion del doctor
						", name string" + 		  // Nombre del doctor
						", password string" + 	  // Contrase�a del doctor
						", address string" +	  // Direcci�n de residencia del doctor
						", mail string" +		  // Correo electr�nico del doctor
						")");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			
			try {
				statement.executeUpdate("create table appointment " +
						"(number INTEGER PRIMARY KEY AUTOINCREMENT" +          // Numero de cita
						", reason string" +           // razon por la que se da la cita
						", date_ini date" +		  // fecha de inicio de la cita
						", id_doctor integer" +	
						", id_patient integer" +	
						")");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			log( Level.INFO, "Creada base de datos", null );
			return statement;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en creación de base de datos", e );
			return null;
		}
	}

	/** Reinicia en blanco las tablas de la base de datos. 
	 * Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexion ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists patient");
			statement.executeUpdate("drop table if exists doctor");
			statement.executeUpdate("drop table if exists appointment");
			log( Level.INFO, "Reiniciada base de datos", null );
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en reinicio de base de datos", e );
			return null;
		}
	}

	/** Cierra la base de datos abierta
	 * @param con	Conexion abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( Connection con ) {
		try {
			//if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Cierre de base de datos", null );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en cierre de base de datos", e );
		}
	}


	/////////////////////////////////////////////////////////////////////
	//                Operaciones sobre la tabla del paciente          //
	/////////////////////////////////////////////////////////////////////


	/** A�ade un paciente a la tabla abierta de BD, usando la sentencia INSERT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al paciente)
	 * @param patient	Paciente a a�adir en la base de datos
	 * @return	true si la inserci�n es correcta, false en caso contrario
	 */
	public static boolean patientInsert( Statement st, Patient patient ) {
		String sentSQL = "";
		try {
			sentSQL = "insert into patient (id, name, password, address, mail) values(" +
					"'" +patient.getId() + "', " +
					secu(patient.getName())  + ", " +
					patient.getPassword() + ", " +
					patient.getAddress() + ", " +
					patient.getMail() +
					")";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			return false;
		}
	}

	/** Realiza una consulta a la tabla abierta de pacientes de la BD, usando la sentencia SELECT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al paciente)
	 * @param idpatient	Id de paciente a buscar
	 * @return	true si el paciente ya existe, false en caso contrario
	 */
	public static boolean patientSelect( Statement st, String namepatient ) {
		String sentSQL = "";
		try {
			sentSQL = "select * from patient where name='" + secu(namepatient) +"'";
			ResultSet rs = st.executeQuery( sentSQL );
			boolean existe = rs.next();  // Si existe el resultset no es vacío
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return existe;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}

	/** Modifica un paciente en la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al paciente)
	 * @param patient	Paciente a modificar en la base de datos. Se toma su id como clave
	 * @return	true si la modificacion es correcta, false en caso contrario
	 */
	public static boolean patientUpdate( Statement st, Patient patient ) {
		String sentSQL = "";
		try {
			sentSQL = "update patient set" +
					" id=" + patient.getId() + ", " +
					" password=" + patient.getPassword() + ", " +
					" address=" + patient.getAddress() + ", " +
					" mail=" + patient.getMail() +
					" where name='" + secu(patient.getName()) + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}

	/** Borrar un Paciente de la tabla abierta de BD, usando la sentencia DELETE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al paciente)
	 * @param patient	Paciente a borrar de la base de datos  (se toma su id para el borrado)
	 * @return	true si el borrado es correcto, false en caso contrario
	 */
	public static boolean patientDelete( Statement st, Patient patient) {
		String sentSQL = "";
		try {
			sentSQL = "delete from patient where name='" + secu(patient.getName())+ "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}

	/////////////////////////////////////////////////////////////////////
	//                Operaciones sobre la tabla del doctor            //
	/////////////////////////////////////////////////////////////////////
	
	public static boolean doctorInsert( Statement st, Doctor doctor) {
		String sentSQL = "";
		try {
			sentSQL = "insert into doctor (id, name, password, address, mail) values(" +
					"'" + doctor.getId() + "', " +
					secu(doctor.getName()) + ", " +
					doctor.getPassword() + ", " +
					doctor.getAddress() + ", " +
					doctor.getAddress() + ", " +
					doctor.getMail() +
					")";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que a�adir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			return false;
		}
	}

	public static boolean doctorSelect( Statement st, String namedoctor ) {
		String sentSQL = "";
		try {
			sentSQL = "select * from doctor where name='" + secu(namedoctor) +"'";
			ResultSet rs = st.executeQuery( sentSQL );
			boolean existe = rs.next();  // Si existe el resultset no es vacio
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return existe;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}
	
	//metodo para seleccionar los nombres de los doctores
	
	public static ArrayList<String> selectAll(Connection conn, Statement stmt){
        String sql = "select * from doctor";
        ArrayList<String> arlist = new ArrayList<String>( );
        try ( ResultSet rs  = stmt.executeQuery(sql)){
            
            // loop through the result set
        	
        	
            while (rs.next()) {
            
            arlist.add(rs.getString("name"));
            
            rs.close();    
           
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
            
        }
        
		return arlist;
    }
   
    
	

	public static boolean doctorUpdate( Statement st, Doctor doctor ) {
		String sentSQL = "";
		try {
			sentSQL = "update doctor set" +
					" id=" + doctor.getId() + ", " +
					" password=" + doctor.getPassword() + ", " +
					" address=" + doctor.getAddress() + ", " +
					" mail=" + doctor.getMail() +
					" where name='" + secu(doctor.getName()) + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) { 
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}


	public static boolean doctorDelete( Statement st, Doctor doctor ) {
		String sentSQL = "";
		try {
			sentSQL = "delete from doctor where name='" + secu(doctor.getName())+ "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////
	//             Operaciones sobre la tabla de las citas             //
	/////////////////////////////////////////////////////////////////////
	
	public static boolean appointmentInsert( Statement st, Appointment appointment ) {
		String sentSQL = "";
		try {
			sentSQL = "insert into appointment (number, reason, date_ini, id_doctor, id_patient) values(" +
					"'" + 	secu(appointment.getId()) + "', " +
					appointment.getReason() + ", " +
					appointment.getIniH() +", " +
					appointment.getId_doctor() +", " +
					appointment.getId_patient() +
					")";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD a�adida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que a�adir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			return false;
		}
	}
	
	

	public static boolean appointmentSelect( Statement st, String idappointment ) {
		String sentSQL = "";
		try {
			sentSQL = "select * from appointment where id='" + secu(idappointment) +"'";
			ResultSet rs = st.executeQuery( sentSQL );
			boolean existe = rs.next();  // Si existe el resultset no es vacio
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return existe;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}

	public static boolean appointmentUpdate( Statement st, Appointment appointment ) {
		String sentSQL = "";
		try {
			sentSQL = "update appointment set" +
					" number=" + appointment.getId() + ", " +
					" reason=" + appointment.getReason() + ", " +
					" date=" + appointment.getIniH() + ", " +
					" id_doctor=" + appointment.getId_doctor() + ", " +
					" id_patient=" + appointment.getId_patient() + "'";
			
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) { 
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}


	public static boolean appointmentDelete( Statement st, Appointment appointment ) {
		String sentSQL = "";
		try {
			sentSQL = "delete from appointment where number='" + secu(appointment.getId()) + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	

	/////////////////////////////////////////////////////////////////////
	//                      Metodos privados                           //
	/////////////////////////////////////////////////////////////////////

	// Devuelve el string "securizado" para volcarlo en SQL
	private static String secu( String string ) {
		return string.replaceAll( "'",  "''" );
	}

	/////////////////////////////////////////////////////////////////////
	//                      Logging                                    //
	/////////////////////////////////////////////////////////////////////

	private static Logger logger = null;

	// Metodo local para loggear
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( SqliteDatabase.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}

}
