/**
 * @author Federico Amici
 * @date 08 feb 2016
 */
package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author feder_000
 *
 */
//public class MyObjectOutputStream extends ObjectOutputStream{
//
//	/**
//	 * @throws IOException
//	 * @throws SecurityException
//	 */
//	public MyObjectOutputStream(FileOutputStream fos) throws IOException, SecurityException {
//		super(fos);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	  protected void writeStreamHeader() throws IOException {
//	    // do not write a header, but reset:
//	    // this line added after another question
//	    // showed a problem with the original
//		reset();
//	  }	
//}

public class MyObjectOutputStream extends ObjectOutputStream {

	/**
	 * @throws IOException
	 * @throws SecurityException
	 */
	//create an object of SingleObject
	   private static MyObjectOutputStream instance = null;

	   private MyObjectOutputStream () throws IOException{}
	   
	   //make the constructor private so that this class cannot be
	   //instantiated
	   private MyObjectOutputStream (FileOutputStream fos) throws IOException{
		   if(instance == null) {
			   instance = super(fos);
			   
			return instance;
	   }

	   //Get the only object available
	   public static MyObjectOutputStream getInstance(){
	      return instance;
	   }

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }

	@Override
	  protected void writeStreamHeader() throws IOException {
	    // do not write a header, but reset:
	    // this line added after another question
	    // showed a problem with the original
		reset();
	  }	
}
