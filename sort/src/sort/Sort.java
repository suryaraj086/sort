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

	public static int kthSmallest(int[] arr, int k) {
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

	static ArrayList<Integer> candyStore(int candies[], int n, int k) {
		Arrays.sort(candies);

		k++;
		int min1 = 0;
		int min2 = 0;

		int req = n / k;
		if (n % k != 0) {
			req++;
		}

		int i;
		for (i = 0; i < req; i++) {
			min1 += candies[i];
		}

		for (i = n - 1; i >= n - req; i--) {
			min2 += candies[i];
		}

		ArrayList<Integer> res = new ArrayList<>();
		res.add(min1);
		res.add(min2);
		return res;

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
		int start = 0, end = n - 1;
		int ans = arr[0] + arr[n - 1];
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum == 0) {
				return 0;
			}
			if (sum < 0) {
				start++;
			} else {
				end--;
			}
			if (Math.abs(sum) < Math.abs(ans)) {
				ans = sum;
			}
			if (Math.abs(sum) == Math.abs(ans)) {
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}

	public static boolean isAnagram(String a, String b) {
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	static void sortABS(int arr[], int n, int k) {
		TreeMap<Integer, List<Integer>> sorted = new TreeMap<>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (sorted.get(Math.abs(k - arr[i])) == null) {
				list = new ArrayList<Integer>();
				sorted.put(Math.abs(k - arr[i]), list);
			}
			list = sorted.get(Math.abs(k - arr[i]));
			list.add(arr[i]);
		}
		Set<Integer> key = sorted.keySet();
		int j = 0;

		for (int temp : key) {
			List<Integer> list1 = sorted.get(temp);
			for (int m = 0; m < list1.size(); m++) {
				arr[j] = list1.get(m);
				j++;
			}
		}
	}

	public int minSwaps(int nums[]) {
		int n = nums.length;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nums[i];
		}
		Arrays.sort(a);
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hm.put(a[i], i);
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			while (hm.get(nums[i]) != i) {
				count++;
				swap(nums, hm.get(nums[i]), i);
			}
		}
		return count;
	}

	static void swap(int a[], int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {

			if (arr[j] <= pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	void quickSort(int arr[], int low, int high) {
		if (low < high) {

			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	// bubble sort
	void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				// check nearby elements
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

//selection sort
	void selectionSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

//quick sort using while
	private void quicksort(int low, int high, int[] numbers, int number) {
		int i = low, j = high;
		int pivot = numbers[low + (high - low) / 2];
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}

			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(i, j, numbers);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j, numbers, number);
		if (i < high)
			quicksort(i, high, numbers, number);
	}

	private void exchange(int i, int j, int[] numbers) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	
	
	

	public static void main(String[] args) {
		Sort sObj = new Sort();
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		switch (val) {
		case 1: {
			long[] arr = { 29, 13, -6, -32, -12 };
			sObj.bitonicGenerator(arr, arr.length);
			break;
		}
		case 2: {
			int[] arr = { 29, 13, -6, -32, -12 };
			System.out.println(sObj.candyStore(arr, arr.length, val));
			break;
		}
		case 3: {
			int[] arr = { 29, 13, -6, -32, -12 };
			System.out.println(closestToZero(arr, arr.length));
			break;
		}
		case 4: {
			int[] arr = { 29, 13, -6, -32, -12 };
			System.out.println(sObj.arraySortedOrNot(arr, arr.length));
			break;
		}
		case 5: {
			int[] arr = { 29, 13, -6, -32, -12 };
			int k = scan.nextInt();
			System.out.println(toyCount(arr.length, k, arr));
			break;
		}
		case 6: {
			int[] arr = { 29, 13, -6, -32, -12 };
			int k = scan.nextInt();
			sObj.merge(arr, arr, arr.length, arr.length);
			break;
		}
		case 7: {
			int[] arr = { 29, 13, -6, -32, -12 };
			int k = scan.nextInt();
			System.out.print(kthSmallest(arr, k));
			break;
		}
		case 8: {
			long[] arr = { 29, 13, -6, -32, -12 };
			System.out.print(check(arr, arr, arr.length));
			break;
		}
		case 10: {
			int[] arr = { 29, 13, -6, -32, -12 };
			sObj.quickSort(arr, 0, arr.length - 1);
			System.out.print(Arrays.toString(arr));
			break;
		}
		case 9: {
			String a = "s";
			String b = "s";
			System.out.print(isAnagram(a, b));
			break;
		}

		default:
			break;
		}

	}

}
