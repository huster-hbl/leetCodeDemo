package number_912;


public class Solution {

    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }

    public int[] selectSort(int[] nums) {
        int n = nums.length;
        int min;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
        return nums;
    }

    public int[] insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int v = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > v) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = v;
        }
        return nums;
    }

    public int[] mergeSort(int[] nums) {
        return null;
    }

    //quick sort;
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        int pivot;
        if (high > low) {
            pivot = partion(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private int partion(int[] nums, int low, int high) {
        int pivot = low;
        int index = pivot + 1;
        for (int i = index; i <= high; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 7, 3, 6, 5};
        new Solution().insertSort(nums);
    }
}
