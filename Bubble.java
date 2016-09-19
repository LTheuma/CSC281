import java.util.Scanner;
import java.util.Arrays;

class Bubble {

    public static void sort(int[] array) {

	boolean madeSwap;
	
	do {
	    madeSwap = false;
	    for(int i = 0; i < array.length-1; i++) {
		if( array[i] > array[i+1] ) {
		    int temp = array[i+1];
		    array[i+1] = array[i];
		    array[i] = temp;
		    madeSwap = true;
		}
	    }
	} while(madeSwap);

    }
    

    public static void main(String[] args) {

	// read the array from stdin
	Scanner scanner = new Scanner(System.in);
	int arraySize = scanner.nextInt();
	int[] array = new int[arraySize];
	for(int i = 0; i < arraySize; i++)
	    array[i] = scanner.nextInt();

	System.out.println("Array loaded, sorting");
	
	sort(array);

	System.out.println(Arrays.toString(array));
	

    }

}
