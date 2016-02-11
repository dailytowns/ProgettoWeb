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
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idCliente;
	private String userName;
	private String password;
	private String nome;
	private String cognome;
	private String nazione;
	private String citta;
	private String indirizzo;
	private String email;
	private String numeroTelefono;
	
	private static int counter = 0;

	public Cliente() {
		this.setIdCliente(++counter);
	}
	
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return counter;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the nazione
	 */
	public String getNazione() {
		return nazione;
	}

	/**
	 * @param nazione the nazione to set
	 */
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the numeroTelefono
	 */
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	/**
	 * @param numeroTelefono the numeroTelefono to set
	 */
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String recuperaUtente(String s) throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream("C:/Users/feder_000/workspace/RentFlatWeb/Clienti.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Cliente c;
		
		while (fis.available() > 0) {
			Object retrieved = ois.readObject();
			if(retrieved instanceof Cliente) {
				c = (Cliente) retrieved;
				if(c.getUserName().equals(s)) {
					ois.close();
					return c.getNome();
				}
			}
		}
		ois.close();
		return null;
	}

	public String recuperaNome(String s) throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream("C:/Users/feder_000/workspace/RentFlatWeb/Clienti.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Cliente c;
		
		while (fis.available() > 0) {
			Object retrieved = ois.readObject();
			if(retrieved instanceof Cliente) {
				c = (Cliente) retrieved;
				if(c.getUserName().equals(s)) {
					ois.close();
					return (c.getNome());
				}
			}
		}
		ois.close();
		return null;
		
	}
	
	public static void main(String[] args) throws IOException {
		Cliente c1 = new Cliente();
		c1.setCitta("Roma");
		c1.setCognome("Rossi");
		c1.setEmail("mario.rossi@gmail.com");
		c1.setIndirizzo("Via Alessandria");
		c1.setNazione("Italia");
		c1.setNome("Mario");
		c1.setNumeroTelefono("060606");
		c1.setUserName("mariorozzo");
		c1.setPassword("sonoilredelmondo");

		Cliente c2 = new Cliente();
		c2.setCitta("Roma");
		c2.setCognome("Rossi");
		c2.setEmail("paolo.rossi@gmail.com");
		c2.setIndirizzo("Via Alessandria");
		c2.setNazione("Italia");
		c2.setNome("Paolo");
		c2.setNumeroTelefono("060606");
		c2.setUserName("paolorozzo");
		c2.setPassword("pureio");
			
		FileOutputStream fos = new FileOutputStream("C:/Users/feder_000/workspace/RentFlatWeb/Clienti.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c1);
		oos.writeObject(c2);
		oos.close();
	}
	
}
