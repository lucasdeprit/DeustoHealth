package bd;
import java.io.File;
import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import progIII.logic.Patient;
public class Conexion {
	File ruta;
	public Conexion(File bd) {
		this.ruta=bd;
	}
	public String getRuta() {
		return ruta.getPath();
	}
	public void setRuta(File ruta) {
		this.ruta = ruta;
	}
	public void insertPatient(Patient p) {
		//Importante que la ruta acabe con un fichero .test Ejemplo: bd.test
		ODB odb = ODBFactory.open(this.getRuta());
		odb.store(p);
		odb.close();
	}
	public void insertPatientList(Objects<Patient> lista) {
		ODB odb = ODBFactory.open(this.getRuta());
		for (int i = 0; i < lista.size(); i++) {
			odb.store(i);
		}
		odb.close();
	}
	public void imprimirBDPatient() {
		ODB odb = ODBFactory.open(this.getRuta());
		//Generamos un conjunto de objetos y los traemos a odb conectado Estaria bien que en vez de patient fuese User pero no consigo ponerlo asi
		Objects<Patient> objects=odb.getObjects(Patient.class);
		//Numero de objetos en la BD
		System.out.println(objects.size()+"Patients: ");
		int i=1;
		while(objects.hasNext()){

		       // Creo un objeto Patient y almaceno ahí el objeto
		       Patient p= objects.next();
		      
		       // Imprimo las propiedades que me interes de ese objeto en este caso todas
		       System.out.println((i++) + "\t: " + p.toString());
		 }
		odb.close();
		
	}
	public Objects<Patient> ReturnBdinList(){
		ODB odb = ODBFactory.open(this.getRuta());
		Objects<Patient> objects=odb.getObjects(Patient.class);
		odb.close();
		return objects;
		
	}
}
