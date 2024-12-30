package practice2024;

// https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingNumber {

	public int findKthPositive(int[] arr, int k) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + ((end-start)/2);
			if((arr[mid] - (mid + 1)) < k) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
        // a[end] + k - (a[end] - (end+1)) == k + (end+1) == k + left
		return k + start;

    }

    public static void main(String[] args) {
        KthMissingNumber kmsn = new KthMissingNumber();

        System.out.println(kmsn.findKthPositive(new int[]{2,3,4,7,11}, 5));
    }


}


