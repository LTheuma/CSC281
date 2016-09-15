import java.awt.*;

class DrawTestTwo {

    public static void main(String[] args) {

	double bigRadius   = Double.parseDouble(args[0]);
	double smallRadius = Double.parseDouble(args[1]);
	double offset      = Double.parseDouble(args[2]);

	double radiusSum = bigRadius+smallRadius;

	double maxExtent = bigRadius+2*smallRadius+offset;
	StdDraw.setXscale(-maxExtent,maxExtent);
	StdDraw.setYscale(-maxExtent,maxExtent);

	// draw an epicycloid
	// see https://en.wikipedia.org/wiki/Epicycloid
	for(int i = 0; i < 20*360; i++)
	    StdDraw.line(radiusSum*Math.cos(Math.PI*i/180.0)
			 -(smallRadius+offset)*Math.cos(radiusSum*Math.PI*i/180.0/smallRadius),
			 radiusSum*Math.sin(Math.PI*i/180.0)
			 -(smallRadius+offset)*Math.sin(radiusSum*Math.PI*i/180.0/smallRadius),
			 radiusSum*Math.cos(Math.PI*(i+1)/180.0)
			 -(smallRadius+offset)*Math.cos(radiusSum*Math.PI*(i+1)/180.0/smallRadius),
			 radiusSum*Math.sin(Math.PI*(i+1)/180.0)
			 -(smallRadius+offset)*Math.sin(radiusSum*Math.PI*(i+1)/180.0/smallRadius));
    }
}
