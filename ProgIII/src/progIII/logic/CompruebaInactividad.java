package progIII.logic;

import java.util.logging.Logger;

public class CompruebaInactividad extends NotifyingThread {
	static int segundos;
	public static Logger logger = Logger.getLogger(CompruebaInactividad.class.getName());
	public boolean hayActividad;

	public CompruebaInactividad(int segundos) {
		this.segundos = segundos;
	}

	@Override
	public void doRun() {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {

		}

	}

}
