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
import java.io.Serializable;

/**
 * @author feder_000
 *
 */
public class Struttura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idStruttura;
	private String tipologia;
	private String nome;
	private int numeroStanze;
	private String sitoWeb;
	private String paese;
	private String citta;
	private String indirizzo;
	private String cap;
	private String descrizione;
	//!!
	private int numSegnalazioni;

	public int getId() {
		return idStruttura;
	}
	
	public void setId(int idStruttura) {
		this.idStruttura = idStruttura;
	}
	
	public String getTipologia() {
		return tipologia;
	}
	
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumeroStanze() {
		return numeroStanze;
	}

	public void setNumeroStanze(int numeroStanze) {
		this.numeroStanze = numeroStanze;
	}
	
	public String getSitoWeb() {
		return sitoWeb;
	}
	
	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}
	
	public String getPaese() {
		return paese;
	}
	
	public void setPaese(String paese) {
		this.paese = paese;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public static void salvaStruttura(Struttura s) throws IOException, ClassNotFoundException {
		System.out.println("In salvaStruttura");
		FileOutputStream fos = new FileOutputStream("./Strutture.ser", true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.close();
		
		FileInputStream fis = new FileInputStream("./Strutture.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		
		if(o instanceof Struttura) {
			System.out.println(s.getSitoWeb());
		}
		ois.close();
	}
}
