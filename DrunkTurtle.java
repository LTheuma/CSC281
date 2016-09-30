import java.awt.*;

public class DrunkTurtle {
    public static void main(String[] args) {

	int numTurtles = Integer.parseInt(args[0]);

	Turtle[] turtles = new Turtle[numTurtles];

	
	for(int i = 0; i < numTurtles; i++) {
	    Color c = new Color((float)Math.random(),
				(float)Math.random(),
				(float)Math.random());
	    turtles[i] = new Turtle(c);
	}
	
	for(int i =0 ; i < 10_000; i++) {
	    for(int t = 0; t < numTurtles; t++) {
		turtles[t].rtd(360*Math.random());	    
		turtles[t].fd(10);
	    }
	}
    }
}
