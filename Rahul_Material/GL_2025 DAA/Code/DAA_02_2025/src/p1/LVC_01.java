import java.util.Scanner;

public class LVC_01 {
	public static void main(String[] args) {
		int arr[] = {64, 25, 12, 22, 11};
		printValues(arr);
		selectionSort(arr);
		printValues(arr);
	}

//print the values of array
	private static void printValues(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i] + " ");
		}
		System.out.println("]");
	}

//Take input from the user
	private static void getValues(int[] arr) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter The value of index " + i);
			arr[i] = sc.nextInt();
		}
	}

	public int search(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}

	public int binarysearch(int[] nums, int target) {
		int beg = 0;
		int end = nums.length - 1;
		int mid;
		while (beg <= end) {
			mid = (beg + end) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				beg = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public void bubbleSort(int[] arr) {

		// Passes are one less than size of the array
		// for is used for pass
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) { // used for comparison
			flag = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = false;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (flag == true)
				break;
		}
	}

	static void selectionSort(int arr[]) {
		int min;
		int pos = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			min = Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					pos = j;
				}
			}
			
			int temp = arr[i];
			arr[i]=arr[pos];
			arr[pos]=temp;
			
		}
	}
}
