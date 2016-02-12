/**
 * @author Federico Amici
 * @date 07 feb 2016
 */
package Entity;


import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import utils.MyObjectOutputStream;

/**
 * @author feder_000
 *
 */
public class Segnalazione implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private String tipoSig;
	private String descrizione;
	private Camera camera;
	private Cliente cliente;
	private int idSegnalazione;
	private Date date;
	
	private static int counter = 0;
	
	public Segnalazione() {
		this.idSegnalazione = counter++;
		this.date = new Date();
	}
	
	/**
	 * @return the tipoSig
	 */
	public String getTipoSig() {
		return tipoSig;
	}
	/**
	 * @param tipoSig the tipoSig to set
	 */
	public void setTipoSig(String tipoSig) {
		this.tipoSig = tipoSig;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * @return the camera
	 */
	public Camera getCamera() {
		return camera;
	}
	/**
	 * @param camera the camera to set
	 */
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void salva() throws IOException, ClassNotFoundException {
		String path = "C:/Users/feder_000/workspace/RentFlatWeb/Segnalazioni.ser";
		FileOutputStream fos = new FileOutputStream(path, true);
		MyObjectOutputStream oos = MyObjectOutputStream.getInstance(fos);
		oos.writeObject(this);
		oos.flush();
		//Lo stream non può essere chiuso, non verrà creata un'altra istanza --> IOException
		//oos.close();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
//		FileOutputStream fos = new FileOutputStream("C:/Users/feder_000/workspace/RentFlatWeb/Segnalazioni.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		Camera c1 = new Camera();
//		c1.setNumeroOspiti(2);
//		c1.aggiungiFoto("FotoTesta", 0);
//		
//		Segnalazione s1 = new Segnalazione();
//		s1.setDescrizione("Segnalazione di testa");
//		s1.setTipoSig("0");
//		s1.setCamera(c1);	
//		
//		oos.writeObject(s1);
		
		FileInputStream fis = new FileInputStream("C:/Users/feder_000/workspace/RentFlatWeb/Segnalazioni.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Segnalazione s;
		Object retrieved;
		try {
		while(!(retrieved = ois.readObject()).equals(null)) {	
				if(retrieved instanceof Segnalazione) {
					s = (Segnalazione) retrieved;
					System.out.println(s.getDescrizione() + " " + s.getCamera().getIdCamera());
				}
			}
		} catch (EOFException e) {
		}
		
		ois.close();
	}

}
