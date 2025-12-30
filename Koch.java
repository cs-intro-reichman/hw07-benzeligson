/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		/* 
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		if (n == 1) return;
		//the dot third way from x1,y1 to x2,y2
		double x3 =(2 * x1 + x2) / 3;
		double y3 = (2 * y1 + y2) / 3;
		// the dot of the triangle's vertex
		double x4 = (Math.pow(3, 0.5) / 6) * (y1 - y2) + (x1 + x2) / 2;
		double y4 = (Math.pow(3, 0.5) / 6) * (x2 - x1) + (y1 + y2) / 2;
		//the dot two thirds of the way from x1,y1 to x2,y2
		double x5 = (x1 + 2 * x2) / 3;
		double y5 = (y1 + 2 * y2) / 3;
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.line(x3, y3, x5, y5);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(x4, y4, x5, y5);
		StdDraw.line(x4, y4, x3, y3);
	
		curve(n - 1, x1, y1, x3, y3);
		curve(n - 1, x3, y3, x4, y4);
		curve(n - 1, x4, y4, x5, y5);
		curve(n - 1, x5, y5, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.2);
		StdDraw.setXscale(0, 1.2);
		// Draws a Koch snowflake of depth n
		curve(n, 0.1, (Math.pow(3, 0.5) / 2), 1.1, (Math.pow(3, 0.5) / 2));
		curve(n, 1.1, (Math.pow(3, 0.5) / 2), 0.6, 0);
		curve(n, 0.6, 0, 0.1, (Math.pow(3, 0.5) / 2));
	}
}
