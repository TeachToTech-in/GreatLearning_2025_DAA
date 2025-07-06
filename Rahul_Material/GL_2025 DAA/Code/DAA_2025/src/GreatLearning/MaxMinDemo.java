package GreatLearning;

class MinMax {
	int min, max;

	@Override
	public String toString() {
		return "MinMax [min=" + min + ", max=" + max + "]";
	}

}

class MaxMinDC {
	static MinMax getMinMax(int[] arr, int low, int high) {
		MinMax result = new MinMax();
		if (low == high) {
			result.min = result.max = arr[low];
			return result;
		}
		if (high == low + 1) {
			if (arr[low] > arr[high]) {
				result.max = arr[low];
				result.min = arr[high];
			} else {
				result.max = arr[high];
				result.min = arr[low];
			}
			return result;
		}
		int mid = (low + high) / 2;
		MinMax left = getMinMax(arr, low, mid);
		MinMax right = getMinMax(arr, mid + 1, high);
		result.min = Math.min(left.min, right.min);
		result.max = Math.max(left.max, right.max);
		return result;
	}
}

public class MaxMinDemo {
	public static void main(String[] args) {
		int arr[] = new int[] { 55, 33, 22, 66, 777, 99, 55, 1 };
		MinMax mm = MaxMinDC.getMinMax(arr, 0, arr.length - 1);
		System.out.println(mm);
	}

}
