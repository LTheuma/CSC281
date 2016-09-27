import java.util.Scanner;
import java.util.Arrays;

class Insertion {

    public static void sort(int[] array) {

	for(int i = 1; i < array.length; i++) {
	    // let the next item "sink" down to it's appropriate
	    // level.
	    for(int j = i; j > 0 && array[j] < array[j-1]; j--) {
		int temp = array[j-1];
		array[j-1] = array[j];
		array[j] = temp;
	    }	    
	}
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
