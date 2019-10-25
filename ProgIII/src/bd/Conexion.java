package bd;
import java.io.File;
import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import progIII.logic.Patient;
public class Conexion {
	private File ruta;
	private ODB odb;
	public Conexion(File bd) {
		this.ruta=bd;
		this.odb=null;
	}
	public String getRuta() {
		return ruta.getPath();
	}
	public void setRuta(File ruta) {
		this.ruta = ruta;
	}
	public void insertPatient(Patient p) {
		//Importante que la ruta acabe con un fichero .test Ejemplo: bd.test
		this.odb.store(p);
	}
	public void insertPatientList(Objects<Patient> lista) {
		for (int i = 0; i < lista.size(); i++) {
			this.odb.store(i);
		}
		
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
	public void abrir() {
		this.odb = ODBFactory.open(this.getRuta());
	}
	public void cerrar() {
		this.odb.close();
	}
}
