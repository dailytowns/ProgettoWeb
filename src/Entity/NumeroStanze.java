/**
 * @author Federico Amici
 * @date 11 feb 2016
 */
package Entity;

import java.io.Serializable;

/**
 * @author feder_000
 *
 */
public class NumeroStanze implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int value;

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
}
