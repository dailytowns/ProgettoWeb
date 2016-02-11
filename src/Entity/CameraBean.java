/**
 * @author Federico Amici
 * @date 10 feb 2016
 */
package Entity;

import java.io.Serializable;

/**
 * @author feder_000
 *
 */
public class CameraBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int numOspiti;
	private String checkIn;
	private String checkOut;
	private String tipologia;
	/**
	 * @return the numOspiti
	 */
	public int getNumOspiti() {
		return numOspiti;
	}
	/**
	 * @param numOspiti the numOspiti to set
	 */
	public void setNumOspiti(int numOspiti) {
		this.numOspiti = numOspiti;
	}
	/**
	 * @return the checkIn
	 */
	public String getCheckIn() {
		return checkIn;
	}
	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	/**
	 * @return the checkOut
	 */
	public String getCheckOut() {
		return checkOut;
	}
	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
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

}
