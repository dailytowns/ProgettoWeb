/**
 * @author Federico Amici
 * @date 04 feb 2016
 */
package Entity;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author feder_000
 *
 */
public class Camera implements Serializable{

	/**
	 * public setDisponibilita
	 */
	private static final long serialVersionUID = 4L;

	private int idCamera;
	private String tipologia;
	private Double prezzo;
	private int numeroOspiti;
	private ArrayList<String> servizi;
	private String[] arrayFoto;
	private boolean[] disponibilita;
	//private Cliente cliente;
	private Struttura struttura;
	private int prezzoPerNotte;
	private String descrizioneCamera;
	
	private static int counter = 0;

	public Camera() {
		this.disponibilita = new boolean[366];
		for(int i=0; i<366; i++) {
			this.disponibilita[i] = true;
		}
		this.setIdCamera((++counter));
	}
	
	/**
	 * @return the tipologia
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * @param tipologia the tipologia to set
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the servizi
	 */
	public ArrayList<String> getServizi() {
		return servizi;
	}

	/**
	 * @return the idCamera
	 */
	public int getIdCamera() {
		return idCamera;
	}

	/**
	 * @param idCamera the idCamera to set
	 */
	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}
	
	/**
	 * @param servizi the servizi to set
	 */
	public void setServizi(String arg, String... arguments) {
		//Non potendo avere un costruttore in cui inizializzare la lista,
		//la istanzio in questo metodo. List è un'interfaccia, perciò scelgo
		//l'istanza concreta ArrayList
		if(this.servizi == null)
			this.servizi = new ArrayList<String>();
		this.servizi.add(arg);
		for(String altriServizi : arguments) {
			this.servizi.add(altriServizi);
		}
	}

	/**
	 * @return the numeroOspiti
	 */
	public int getNumeroOspiti() {
		return numeroOspiti;
	}

	/**
	 * @param numeroOspiti the numeroOspiti to set
	 */
	public void setNumeroOspiti(int numeroOspiti) {
		this.numeroOspiti = numeroOspiti;
	}
	
	/**
	 * @return the arrayFoto
	 */
	public String[] getArrayFoto() {
		return arrayFoto;
	}

	/**
	 * @param arrayFoto the arrayFoto to set
	 * @throws ParseException 
	 */
//	public void setArrayFoto(String[] arrayFoto) {
//		this.arrayFoto = arrayFoto;
//	}
	
	public boolean controllaDisponibilita(String in, String out) throws ParseException {
		
		int giornoIn = 0, meseIn = 0, giornoOut = 0, meseOut = 0;
				
			giornoIn = Integer.parseInt(in.substring(0,2));
			giornoOut = Integer.parseInt(out.substring(0,2));
			meseIn = Integer.parseInt(in.substring(3, 5));
			meseOut = Integer.parseInt(in.substring(3, 5));
		
		
//		int annoIn = Integer.parseInt(in.substring(6));
//		int annoOut = Integer.parseInt(out.substring(6));
		
		int i1 = Data.parseData(giornoIn, meseIn);
		int i2 = Data.parseData(giornoOut, meseOut);
		
		for(int i = i1; i<i2; i++) {
			if(this.disponibilita[i] == false)
				return false;
		}
		return true;
	}
	
	public static ArrayList<Camera> recuperaCamere(String checkIn, String checkOut, String tipologia, int numOspiti) throws ClassNotFoundException, IOException, ParseException {
		
		FileInputStream fis = new FileInputStream("C:/Users/feder_000/workspace/RentFlatWeb/Camere.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Camera c;
		ArrayList<Camera> v = new ArrayList<Camera>();
		
		while (fis.available() > 0) {
			Object retrieved = ois.readObject();
			if(retrieved instanceof Camera) {
				c = (Camera) retrieved;
				if(c.getTipologia().equals(tipologia)) {
//					if(c.getNumeroOspiti() == numOspiti) {
//						if(c.controllaDisponibilita(checkIn, checkOut))
//							v.add(c);
					v.add(c);
					}
					
				}
			}
		
		ois.close();
		return v;
	}
	
	private static String encodePhoto(String path) {
		
		File file = new File(path);
		String imageDataString = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			byte imageData[] = new byte[(int) file.length()];
			fis.read(imageData);
			imageDataString = Base64.getEncoder().encodeToString(imageData);
			fis.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return imageDataString;	
	}
	
	public void aggiungiFoto(String s, int i) {
		//Questo controllo permette di non istanziare nuovamente l'attributo
		//se non si sta aggiungendo una foto per la prima volta
		if(this.arrayFoto == null) {
			this.arrayFoto = new String[10];
		}
		this.arrayFoto[i] = s;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
		
		//Nell'inserimento delle camere dalla pagina JSP le costanti saranno rimpiazzate
		//da una variabile (che controlla anche che l'utente non inserisca più di 10 foto
		//per camera
		
//		String path1 = "C:/Users/feder_000/workspace/RentFlatWeb/jpg/flat1.jpg";
//		String path2 = "C:/Users/feder_000/workspace/RentFlatWeb/jpg/flat2.jpg";
//		String path3 = "C:/Users/feder_000/workspace/RentFlatWeb/jpg/flat3.jpg";
//		String path4 = "C:/Users/feder_000/workspace/RentFlatWeb/jpg/flat4.jpg";
//		
//		String photo1 = encodePhoto(path1);
//		String photo2 = encodePhoto(path2);
//		String photo3 = encodePhoto(path3);
//		String photo4 = encodePhoto(path4);
//		
//		Camera c1 = new Camera();
//		c1.setNumeroOspiti(2);
//		c1.setPrezzo(26);
//		c1.setServizi("Wifi", "Spa");
//		c1.setTipologia("Hotel");
//		c1.aggiungiFoto(photo1, 0);
//		c1.aggiungiFoto(photo2, 1);
		
//		
//		Camera c2 = new Camera();
//		c2.setNumeroOspiti(2);
//		c2.setPrezzo(90);
//		c2.setServizi("Wifi", "GitaCavallo");
//		c2.setTipologia("Agriturismo");
//		c2.aggiungiFoto(photo3, 0);
//			
//		Camera c3 = new Camera();
//		c3.setNumeroOspiti(2);
//		c3.setPrezzo(92);
//		c3.setServizi("Wifi", "Spa");
//		c3.setTipologia("Hotel");
//		c3.aggiungiFoto(photo4, 0);
//		
//		FileOutputStream fos = new FileOutputStream("C:/Users/feder_000/workspace/RentFlatWeb/Camere.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(c1);
//		oos.writeObject(c2);
//		oos.writeObject(c3);
//		oos.close();
//		
		FileInputStream fis = new FileInputStream("C:/Users/feder_000/workspace/RentFlatWeb/Camere.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Camera c;
		Object retrieved;
		try {
			while (!((retrieved = ois.readObject()).equals(null))) {	
				if(retrieved instanceof Camera) {
					c = (Camera) retrieved;
//					String[] photos = c.getArrayFoto();
//					if(photos[0].equals(photo1)) {
//						System.out.println("photo2");
//						break;
					System.out.println(c.getIdCamera());
					}
				}
			
			ois.close();
		} catch (EOFException e) {
			e.printStackTrace();
		}
		
		Camera c1 = new Camera();
		c1.controllaDisponibilita("03-08-11", "04-08-11");
	}


}
