import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {
	
	Tree_2_3<Association<String, String>> myTree = new Tree_2_3<>();

	@Test
	public void BSTTest() {
		
		final String temp[] = {"Monday", "Lunes"};

		
		// AGREGAR
		final Association<String, String> a = new Association(temp[0], temp[1]);
        myTree.add(a);
        
        String word = "Monday";
        
        // OBTENER
        // Para cada palabra obtiene la asociacion que coincide con el key
        final Association<String, String> ab = myTree.get(new Association<>(word, null));
        if (ab != null) {
            // Si es que existe una asociacion la agrega en el outputTextArea 
        	String expected = "Lunes";
        	String received = "";
        	
            received = ab.getValue().toString();
            
            assertEquals(expected, received);
            
        } 
	}

}
