package GreatLearning;

public class LVC_02 {

	// Bubble Sort
	public static void BubbleSort(int arr[]) {
		boolean flag = false;
		if (arr == null)
			return;
		// Outer Loop is for Pass
		for (int i = 0; i < arr.length - 1; i++) {
			flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					swap(arr, j, j + 1);
				}

			}
			if (!flag)
				break;
		}

	}

	public static void swap(int arr[], int j, int i) {
		int temp = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = temp;

	}

	// If The element is found in the array it must return the position
	// or return -1 not found
	public static int Search(int arr[], int item) {
		if (arr == null)
			return -1;
		for (int i = 0; i < arr.length; i++)
			if (item == arr[i])
				return i;
		return -1;
	}

	public static void main(String[] args) {
		// int position = Search(new int [] {4,6,5,4,3,6,23,11}, 10);
		// System.out.println(position);
		int[] arr = new int[] { 4, 6, 5, 1, 3, 6 };
		printArray(arr);
		// System.out.println("Minimum Element Position int the Array" + minimum(arr,
		// 0));
		System.out.println("After Sorting Applies");
		// BubbleSort(arr);
		SelectionSort(arr);
		printArray(arr);

	}

	/// Selection Sort - Find Minimum and place it in the beg of the array for
	/// Ascending
	public static void SelectionSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}

	}

	public static int minimum(int[] arr, int start) {
		int pos = start;
		for (int i = start + 1; i < arr.length; i++) {
			if (arr[pos] > arr[i])
				pos = i;
		}
		return pos;

	}
	
	//Merging The Two Sorted Array
//	public static int [] merge(int [] nums1, int [] nums2 [] ) {
//		int i =0;
//		int j=0;
//		while(i<nums1.length && j<nums2.length) {
//			if(nums1[i] < nums2 [j]) {
//				
//			}
//		}
//		return null;
//	}

	public static void printArray(int[] is) {
		System.out.print(" [ ");
		for (int i : is) {
			System.out.print(i + " ,");
		}
		System.out.println(" ] ");

	}
}
