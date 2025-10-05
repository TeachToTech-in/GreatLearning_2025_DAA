package GreatLearning;

class MergeSortSolution {
	public static void merge(int arr[], int si, int mid, int ei) {
		int c[] = new int[ei - si + 1];

		int i = si, j = mid + 1, k = 0;
		while (i <= mid && j <= ei) {
			if (arr[i] <= arr[j]) {
				c[k] = arr[i];
				i++;
			} else {
				c[k] = arr[j];
				j++;
			}
			k++;

		}
		while (i <= mid) {
			c[k] = arr[i];
			i++;
			k++;
		}
		while (j <= ei) {
			c[k] = arr[j];
			j++;
			k++;
		}
		j = 0;
		for (i = si; i <= ei; i++) {
			arr[i] = c[j];

			j++;
		}

	}

	void mergeSort(int arr[], int si, int ei) {

		if (si >= ei) {
			return;
		}
		int mid = si + (ei - si) / 2;
		mergeSort(arr, si, mid);
		mergeSort(arr, mid + 1, ei);
		merge(arr, si, mid, ei);

	}
}
