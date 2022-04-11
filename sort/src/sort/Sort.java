package sort;

import java.util.*;

public class Sort {

	public static boolean check(long A[], long B[], int N) {
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			if (A[i] != B[i]) {
				return false;
			}
		}
		return true;
	}

	public static int kthSmallest(int[] arr, int l, int r, int k) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

	public void merge(int arr1[], int arr2[], int n, int m) {

		int i = n - 1;
		int j = 0;
		while (i >= 0 && j < m) {
			if (arr1[i] > arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
			}
			i--;
			j++;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}

	boolean arraySortedOrNot(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static int toyCount(int N, int K, int arr[]) {
		int temp = 0;
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			if (arr[i] <= K) {
				K = K - arr[i];
				temp++;
			}
		}
		return temp;
	}

	void bitonicGenerator(long arr[], int n) {

		List<Long> temp = new ArrayList<Long>();
		List<Long> temp1 = new ArrayList<Long>();
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				temp.add(arr[i]);
			}
		}
		
		Collections.sort(temp);
		for (int i = n - 1; i >= 0; i--) {
			if (i % 2 == 1) {
				temp1.add(arr[i]);
			}
		}
		Collections.sort(temp1, Collections.reverseOrder());
		j = 0;
		for (long num : temp) {
			arr[j] = num;
			j++;
		}
		for (long num : temp1) {
			arr[j] = num;
			j++;
		}
		System.out.println(Arrays.toString(arr));
	}

	static ArrayList<Integer> candyStore(int candies[], int N, int K) {
		Arrays.sort(candies);
		int temp = N;
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (K == N - 1) {
			list.add(candies[0]);
			list.add(candies[N - 1]);
			return list;
		}
		for (int i = 0; i < N - 1; i++) {
			list.add(candies[i] + candies[i + 1]);
			N = N - K - 1;
		}
		N = temp;
		temp = 1;
		for (int i = N - 2; i > temp; i--) {
			list.add(candies[i] + candies[i + 1]);
			temp = temp + K;
		}

		return list;
	}

	// merge sort
	static void merge(int Arr[], int start, int mid, int end) {
		int temp[] = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (Arr[i] <= Arr[j]) {
				temp[k] = Arr[i];
				k += 1;
				i += 1;
			} else {
				temp[k] = Arr[j];
				k += 1;
				j += 1;
			}
		}
		while (i <= mid) {
			temp[k] = Arr[i];
			k += 1;
			i += 1;
		}
		while (j <= end) {
			temp[k] = Arr[j];
			k += 1;
			j += 1;
		}
		for (i = start; i <= end; i += 1) {
			Arr[i] = temp[i - start];
		}
	}

	static void mergeSort(int Arr[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(Arr, start, mid);
			mergeSort(Arr, mid + 1, end);
			merge(Arr, start, mid, end);
		}
	}

	public static int closestToZero(int arr[], int n) {
		Arrays.sort(arr);
		int zero = 0;
		int temp = 0;
		int min = 0;
		int j = n - 1;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				list.add(arr[i]);
			}
		}
		if (list.get(list.size() - 1) != null) {
			min += list.get(list.size() - 1);
			for (int i = 0; i < n; i++) {
				if (arr[i] > 0) {
					min += arr[i];
					return min;
				}
			}
			if (list.get(list.size() - 2) != null) {
				min += list.get(list.size() - 2);
			}
			return min;
		} else {
			min = arr[0] + arr[1];
		}
		return min;
	}

	public static void main(String[] args) {
		Sort sObj = new Sort();
		int[] arr = { 29, 13, -6, -32, -12 };
		System.out.println(closestToZero(arr, 0));

	}

}
