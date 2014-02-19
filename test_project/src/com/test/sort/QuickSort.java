package com.test.sort;

public class QuickSort {
	
	// preusporada pole na prvky mensi nez pivot, pivot a prvky vetsi nez pivot
	/**
	 * 
	 * @param list
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
	public static int divide(int[] list, int left, int right, int pivot) {
	  int temp = list[pivot]; // prohozeni pivotu s poslednim prvkem
	  list[pivot] = list[right];
	  list[right] = temp;
	  int iter = left;
	  for (int j = left; j < right; j++) {
	    if (list[j] < list[right]) { // prvek je mensi, nez pivot
	      temp = list[iter]; // prohozeni pivotu s prvkem na pozici
	      list[iter] = list[j];
	      list[j] = temp;
	      iter++; // posun pozice
	      System.out.println(iter); // iterator printout
	    }
	  }
	  temp = list[iter]; // prohozeni pivotu zpet
	  list[iter] = list[right];
	  list[right] = temp;
	  return iter; // vrati novy index pivotu
	}

	/**
	 * 
	 * @param list
	 * @param left
	 * @param right
	 */
	public static void limited_quicksort(int[] list, int left, int right) {
	  if (right >= left) { // podminka rekurze
	    int pivot = left; // vyber pivotu
	    int new_pivot = divide(list, left, right, pivot);
	    // rekurzivni zavolani na obe casti pole
	    limited_quicksort(list, left, new_pivot - 1);
	    limited_quicksort(list, new_pivot + 1, right);
	  }
	}

/**
 * 
 * @param list
 */
	public static void quicksort(int[] list) {
	  limited_quicksort(list, 0, list.length - 1);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
	  int[] sortMe = {8,5,7,2,0,3,4,5,8,7,0,2,9,4,2};
	  System.out.println(sortMe);
	  quicksort(sortMe);
	  System.out.println(sortMe);
  }

}
