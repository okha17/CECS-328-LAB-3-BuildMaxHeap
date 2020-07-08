// ============================================================================
// CECS 328 Lab Assignment 3
// ============================================================================
// Team Members:
// Kevin Vu
// Osman Khan
// Anthony Dawson
// ============================================================================

public class BuildMaxHeap{

	public static void main(String[] args) {
		
		
		int[] A = new int[args.length];
		
		//converting String elements from args into Integers.
		for (int i = 0; i < args.length; i++) {
			A[i] = Integer.parseInt(args[i]);
		}
		
		//Building Max Heap------------------------------------
		//Since the array starts at zero instead of one,
		//we subtract 1 to make the formula work. 
		for (int i = (A.length / 2) - 1; i >= 0; i--)
			MaxHeapify(A,i);
		
		
		System.out.println("Max Heap Array:");
		for(int n: A) {
			System.out.print(n + " ");
		}
		
		//The height of a tree is lg(X)
		//lg X = log X / log 2
		int height = (int) (Math.log(A.length) / Math.log(2));
		
		System.out.println("\nHeight: " + height);
		
	}
	
	static void MaxHeapify(int []A, int i) {
		
		//again, the array starts at zero, so each branch index will 
		//be one more for each node.
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		
		int largest;
		
		if (l < A.length && A[l] > A[i])
			largest = l;
		else largest = i;
		
		if (r < A.length && A[r] > A[largest])
			largest = r;
		
		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			
			MaxHeapify(A, largest);
		}
	}

}
