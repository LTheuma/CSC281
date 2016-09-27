import java.util.Scanner;
import java.util.Arrays;

public class Merge {

    static int[] aux;
    
    public static void sort(int[] array) {
	aux = new int[array.length];
	sort(array,0,array.length-1);
    }

    private static void sort(int[] array, int low, int high) {
	if( high <= low ) return;
	int mid = low + (high-low)/2; // numerically same as
				      // (high+low)/2, but works
				      // better for int overflow

	sort(array,low,mid);
	sort(array,mid+1,high);
	merge(array,low,mid,high);
    }
    
    private static void merge(int[] array, int low, int mid, int high) {
	int i = low, j = mid + 1;

	for(int k = low; k <= high; k++)
	    aux[k] = array[k];

	for(int k = low; k <= high; k++) {
	    if      (i > mid)         array[k] = aux[j++];
	    else if (j > high )         array[k] = aux[i++];
	    else if (aux[j] < aux[i]) array[k] = aux[j++];
	    else                      array[k] = aux[i++];
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
