//Tyson Hichman, CSCI 333, Quicksort
import java.util.Random;
public class Main {

	//Main class to test my methods
	public static void main(String[] args) {

		int[] sort = new int[] {6, 9, 8, 4, 6, 3, 1, 10, 20, 30, 55, 10, 11, 11156, 2, 1, 50, 90, 90000, 30, 1000000 };
		int[] sorted = CountingSort(sort, 1000000);

		for (int i = 0; i < sorted.length; i++) {

			System.out.print(sorted[i]);
			System.out.print(", ");

		}
		System.out.println();

		
		int[] sort2 = new int[] {1,2,3,4,5,6,7,8,9};
		int sorted2 = randomizedQuickselect(sort2, 0, sort2.length - 1, 3);

		System.out.println(sorted2);

		
		
		int[] sort3 = new int[] {9,8,4,6,5,4,3,2,1,0};
		int[] sorted3 = CountingSort(sort3, 9);

		for (int i = 0; i < sorted3.length; i++) {

			System.out.print(sorted3[i]);
			System.out.print(", ");

		}
		System.out.println();

		
		int[] sort4 = new int[] {9,9,20,50,60,100,1000,9000};
		int sorted4 = randomizedQuickselect(sort4, 0, sort4.length - 1, 5);

		System.out.println(sorted4);
		
		
		int[] sort5 = new int[] {900000000,90,0,0,0,0,0,0,50,50,50,50,50};
		int[] sorted5 = CountingSort(sort5, 900000000);

		for (int i = 0; i < sorted5.length; i++) {

			System.out.print(sorted5[i]);
			System.out.print(", ");

		}
		System.out.println();

		
		int[] sort6 = new int[] {100,2,3,2,6,200,90,5000};
		int sorted6 = randomizedQuickselect(sort6, 0, sort6.length - 1, 1);

		System.out.println(sorted6);
	}

	//counting sort method that swaps numbers in the arrays and uses a count to move integers
	public static int[] CountingSort(int[] array, int max_num) {
		int[] out = new int[array.length];
		int[] num_arr = new int[max_num + 1];

		for (int i = 0; i < max_num; i++) {
			num_arr[i] = 0;
		}

		for (int i = 0; i < array.length; i++) {
			num_arr[array[i]]++;
		}

		for (int i = 1; i <= max_num; i++) {
			num_arr[i] += num_arr[i - 1];
		}

		for (int i = array.length - 1; i >= 0; i--) {
			out[num_arr[array[i]] - 1] = array[i];
			num_arr[array[i]]--;
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = out[i];
		}

		return out;
	}

	//sorts the given array then uses a test statistic to find what number is in the array
	public static int randomizedQuickselect(int[] array, int p, int r, int i) {
		if (p == r) {
			return array[p];
		}

		//finds a random pivot point 
		Random ran = new Random();
		int point = ran.nextInt(r - p) + p;
		//swaps the pivot in the array
		int temp = array[point];
		array[point] = array[r];
		array[r] = temp;

		int q = partition(array, p, r);
		int k = q - p + 1;
		if (i == k) {
			return array[q];
		} else if (i < k) {
			return randomizedQuickselect(array, p, q - 1, i);
		} else {
			return randomizedQuickselect(array, q + 1, r, i - k);
		}
	}

	//standard partition method
	private static int partition(int[] array, int start, int end) {
		int x = array[end];
		int i = start - 1;
		for (int j = start; j <= end - 1; j++) {
			if (array[j] <= x) {
				i = i + 1;

				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		int temp = array[end];
		array[end] = array[i + 1];
		array[i + 1] = temp;

		return i + 1;
	}

}
