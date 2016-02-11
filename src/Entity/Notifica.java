/**
 * @author Federico Amici
 * @date 04 feb 2016
 */
package Entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

/**
 * @author feder_000
 *
 */
public class Notifica {

	private int idNotifica;
	private Cliente mittente;
	private String dettagli;
	
	private static final long serialVersionUID = 1L;
	
	public int getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(int idNotifica) {
		this.idNotifica = idNotifica;
	}

	public Cliente getMittente() {
		return mittente;
	}

	public void setMittente(Cliente mittente) {
		this.mittente = mittente;
	}
	
	public String getDettagli() {
		return dettagli;
	}

	public void setDettagli(String dettagli) {
		this.dettagli = dettagli;
	}
	
	public Notifica(int idNotifica, Cliente mittente, String dettagli) {
		this.idNotifica = idNotifica;
		this.mittente = mittente;
		this.dettagli = dettagli;
	}
	
	public static void creaFileNotifiche() throws IOException, ClassNotFoundException {
		
//		Notifica n1 = new Notifica(0, c1, "Approvazione annuncio");
//		
//		Notifica n2 = new Notifica(1, c2, "Approvazione annuncio");
		
		FileOutputStream fos = new FileOutputStream("./Notifiche.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(n1);
//		oos.writeObject(n2);
		
		FileInputStream fis = new FileInputStream("./Notifiche.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Notifica n;
		while (fis.available() > 0) {
			Object retrieved = ois.readObject();
			if(retrieved instanceof Notifica) {
				n = (Notifica) retrieved;
				if(n.getIdNotifica() == 1)
					System.out.println(n.getMittente().getNome());
			}
		}
		

	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Notifica.creaFileNotifiche();
	}
	
	
}
