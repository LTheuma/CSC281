import java.awt.*;

class DrawTest {

    public static void main(String[] args) {

	StdDraw.setXscale(-1.0,1.0);
	StdDraw.setYscale(-1.0,1.0);

	StdDraw.circle(0,0,1);
	
	for(double i = 0; i <= 1; i += 0.05) {
	    StdDraw.line( 0, 1.0-i, i,0);
	    StdDraw.line( 0, i-1.0, i,0);
	    StdDraw.line( 0, 1.0-i, -i,0);
	    StdDraw.line( 0, i-1.0, -i,0);
	}

    }


}
