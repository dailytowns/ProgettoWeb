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
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	private String checkIn;
	private String checkOut;
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
	
	public static int parseData(int d, int m) {
		
		if(m == 1) { 
			return d-1;
		} else if (m == 2) {
			return (30 + d-1);
		} else if (m == 3) {
			return (59 + d-1);
		} else if (m == 4) {
			return (90 + d-1);
		} else if (m == 5) {
			return (120 + d-1);
		} else if (m == 6) {
			return (151 + d-1);
		} else if (m == 7) {
			return (181 + d-1);
		} else if (m == 8) {
			return (212 + d-1);
		} else if (m == 9) {
			return (243 + d-1);
		} else if (m == 10) {
			return (273 + d-1);
		} else if (m == 11) {
			return (304 + d-1);
		} else if (m == 12) {
			return (335 + d-1);
		}
		
		return m;
		
	}
}
