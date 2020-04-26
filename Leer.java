import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Leer {

	public static String leerTexto() {
		
		String sentence = "";
		
		try {
			
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader("src/texto.txt"));
			
			
			String oracion = "";
			
			while((oracion = reader.readLine()) != null) {
				sentence = oracion;
			}
			
			reader.close();
			
		} catch (Exception e) {
			return "-1";
		}
		
		return sentence;
	}
	
	// TEST ONLY
	public static String leerSpanish() {
		
		String sentence = "";
		
		try {
			
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader("src/Spanish.txt"));
			
			
			String oracion = "";
			
			while((oracion = reader.readLine()) != null) {
				sentence = oracion;
			}
			
			reader.close();
			
		} catch (Exception e) {
			return "-1";
		}
		
		return sentence;
	}
	
}
