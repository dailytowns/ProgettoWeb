/**
 * @author Federico Amici
 * @date 31 gen 2016
 */
package Control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import Entity.Locazione;

/**
 * @author feder_000
 *
 */
public class ControlRicerca {

	public void creaFile() throws IOException, ClassNotFoundException {
		
		Locazione u1 = new Locazione(0, "28/1/1919");
		Locazione u2 = new Locazione(1, "28/1/1920");
		Locazione u3 = new Locazione(2, "Appartamento");
		Locazione u4 = new Locazione(3, "28/1/1922");
		Locazione u5 = new Locazione(4, "Appartamento");
		
		System.out.println(System.getProperty("user.dir"));
		
		FileOutputStream fos = new FileOutputStream("./output.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(u1);
		oos.writeObject(u2);
		oos.writeObject(u3);
		oos.writeObject(u4);
		oos.writeObject(u5);	
		
//		FileInputStream fis = new FileInputStream("./output.ser");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		Locazione uR;
//		
//		while(fis.available() > 0) {
//			Object retrieved = ois.readObject();
//			
//			if(retrieved instanceof Locazione) {
//				uR = (Locazione) retrieved;
//				//42 potrebbe essere la password da matchare
//				if(uR.getId() == 3) {
//					//System.out.println(uR.getName() + " " + uR.getId());
//				}
//		}
	}
	
	public Vector<Locazione> cercaLocazione(String tipo) throws IOException, ClassNotFoundException{
		
		Vector<Locazione> v = new Vector<>();
		
		FileInputStream fis = new FileInputStream("./output.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Locazione uR;
		
		while(fis.available() > 0) {
			Object retrieved = ois.readObject();
			
			if(retrieved instanceof Locazione) {
				uR = (Locazione) retrieved;
				//42 potrebbe essere la password da matchare
				if(uR.getName().equals("Appartamento")) {
					v.addElement(uR);
				}
		}
	}
		
		return v;	
	}
}
