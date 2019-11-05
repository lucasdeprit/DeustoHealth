package bd;
import java.io.File;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import progIII.logic.Doctor;
import progIII.logic.Patient;
public class Conexion {
	private File ruta;
	private ODB odb;
	

	public Conexion(File bd, ODB odb) {
		// TODO Auto-generated constructor stub
		this.ruta=bd;
		this.odb= odb;
	}

	public ODB getOdb() {
		return odb;
	}

	public String getRuta() {
		return ruta.getPath();
	}
	public void setRuta(File ruta) {
		this.ruta = ruta;
	}
	public void insertPatient(Patient p) {
		//Importante que la ruta acabe con un fichero .test Ejemplo: bd.test
		this.getOdb().store(p);
	}
	public void insertPatientList(Objects<Patient> lista) {
		for (int i = 0; i < lista.size(); i++) {
			this.odb.store(i);
		}
		
	}
	private void eliminarPatient(String atributo,String valor) {
		//IQuery query = new CriteriaQuery(Jugadores.class, Where.equal(atributo, valor));
        }
      
	public void imprimirBDPatient() {
		//Generamos un conjunto de objetos y los traemos a odb conectado Estaria bien que en vez de patient fuese User pero no consigo ponerlo asi
		Objects<Patient> objects=this.odb.getObjects(Patient.class);
		//Numero de objetos en la BD
		System.out.println(objects.size()+"Patients: ");
		int i=1;
		while(objects.hasNext()){
		       // Creo un objeto Patient y almaceno ahí el objeto
		       Patient p= objects.next();
		      
		       // Imprimo las propiedades que me interes de ese objeto en este caso todas
		       System.out.println((i++) + "\t: " + p.toString());
		 }
		
	}
	public Objects<Patient> ReturnBdinList(){
		Objects<Patient> objects=this.odb.getObjects(Patient.class);
		return objects;
		
	}
	
	public void setOdb(ODB odb) {
		this.odb = odb;
	}
	public void cerrar() {
		this.odb.close();
	}
}
