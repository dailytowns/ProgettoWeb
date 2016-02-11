/**
 * @author Federico Amici
 * @date 10 feb 2016
 */
package Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Entity.Camera;

/**
 * @author feder_000
 *
 */
@RunWith(Parameterized.class)
public class TestDisponibilita {

		private boolean expected;
		private String in1;
		private String in2;

		
		@Parameters
		public static Collection<Object[]> getOtherParameters(){
			return Arrays.asList(new Object[][]{
					{true, "09-03-11", "19-03-11"}, // expectedPar, par
			});
		}

		public TestDisponibilita(boolean expected, String in1, String in2) {
			this.expected = true;
			this.in1 = in1;
			this.in2 = in2;
		}

		@Test
		public void testFoo() throws ParseException {
			Camera c = new Camera();
			//NumberFormatException
//			boolean result = c.controllaDisponibilita("9-3-14", "19-3-14");
			boolean result = c.controllaDisponibilita("09-03-14", "19-03-14");
			Assert.assertEquals(this.expected, result);
		}
	
}
