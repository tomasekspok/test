package com.test.sort;

public class QuickSort {
	
	// preusporada pole na prvky mensi nez pivot, pivot a prvky vetsi nez pivot
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

	public static void limited_quicksort(int[] list, int left, int right) {
	  if (right >= left) { // podminka rekurze
	    int pivot = left; // vyber pivotu
	    int new_pivot = divide(list, left, right, pivot);
	    // rekurzivni zavolani na obe casti pole
	    limited_quicksort(list, left, new_pivot - 1);
	    limited_quicksort(list, new_pivot + 1, right);
	  }
	}

	// zavola omezeny quicksort na cele pole
	public static void quicksort(int[] list) {
	  limited_quicksort(list, 0, list.length - 1);
	}

}
