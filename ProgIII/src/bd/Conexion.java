package bd;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import progIII.logic.Patient;
public class Conexion {
	String ruta;
	public Conexion(String ruta) {
		this.ruta=ruta;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public void insertPatient(Patient p) {
		//Importante que la ruta acabe con un fichero .test Ejemplo: bd.test
		ODB odb = ODBFactory.open(this.getRuta());
		odb.store(p);
		odb.close();
	}
	public void insertPatientList(String ruta,Objects<Patient> lista) {
		ODB odb = ODBFactory.open(this.getRuta());
		for (int i = 0; i < lista.size(); i++) {
			odb.store(i);
		}
		odb.close();
	}
	public void imprimirBDPatient(String ruta) {
		ODB odb = ODBFactory.open(ruta);
		//Generamos un conjunto de objetos y los traemos a odb conectado Estaria bien que en vez de patient fuese User pero no consigo ponerlo asi
		Objects<Patient> objects=odb.getObjects(Patient.class);
		//Numero de objetos en la BD
		System.out.println(objects.size()+"Patients: ");
		int i=1;
		while(objects.hasNext()){

		       // Creo un objeto Jugadores y almaceno ahí el objeto
		       Patient p= objects.next();
		      
		       // Imprimo las propiedades que me interes de ese objeto en este caso todas
		       System.out.println((i++) + "\t: " + p.toString());
		 }
		odb.close();
		
	}
}
