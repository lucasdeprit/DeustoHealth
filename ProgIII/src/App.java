import javax.swing.UnsupportedLookAndFeelException;

import progIII.gui.Login;

public class App {
	static Login v;
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	v=new Login();
	Login.main(args);
}
}
