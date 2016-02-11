package login;
import java.io.Serializable;

/**
 * @author Federico Amici
 * @date 23 gen 2016
 */

/**
 * @author feder_000
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	public String birthdate;
	private int id;
	private static int counter = 0;
	
	public User() {
		this.name = "";
		this.surname = "";
		this.birthdate = "";
		this.id = 0;
	}
	
	public User(String name, String surname, String birthdate) {
		this.setName(name);
		this.setSurname(surname);
		this.birthdate = birthdate;
		this.setId(++counter);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
}
