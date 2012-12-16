package Main;

public class Run {

	public static void main(String[] args) {
		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/natives/");
		Roket roket = new Roket();
		roket.Run();
		
	}
}
