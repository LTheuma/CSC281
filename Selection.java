import java.util.Scanner;
import java.util.Arrays;

class Selection {

    public static void sort(int[] array) {

	for(int i = 0; i < array.length; i++) {

	    // find the smallest element in the remaining part of the
	    // array
	    
	    int smallestLocation = i;
	    for(int j = i+1; j < array.length; j++) {
		if(array[j] < array[smallestLocation]) {
		    smallestLocation = j;
		}
	    }

	    // swap it to be the last element in the sorted part
	    int temp = array[smallestLocation];
	    array[smallestLocation] = array[i];
	    array[i] = temp;
	    
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
