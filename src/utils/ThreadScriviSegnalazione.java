/**
 * @author Federico Amici
 * @date 12 feb 2016
 */
package utils;

/**
 * @author feder_000
 *
 */
public class ThreadScriviSegnalazione extends Thread {

	private Thread t;
	private String threadName;

	public ThreadScriviSegnalazione(String name){
		threadName = name;
		System.out.println("Creating " +  threadName );
	}

	public void run() {
		
		//Codice che stimola il singleton
		
		System.out.println("Running " +  threadName );
		try {
			for(int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " +  threadName + " interrupted.");
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}

	@Override
	public void start ()
	{
		System.out.println("Starting " +  threadName );
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}



	public static void main(String args[]) {
		   
		ThreadScriviSegnalazione T1 = new ThreadScriviSegnalazione( "Thread-1");
		T1.start();
			  
		ThreadScriviSegnalazione T2 = new ThreadScriviSegnalazione( "Thread-2");
		T2.start();
	}   
}
