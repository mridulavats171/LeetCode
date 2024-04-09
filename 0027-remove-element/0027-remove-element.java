public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    private void sort(int[] nums, int start, int end) {
        Arrays.sort(nums, start, end);
    }

    public void customJudge(int[] nums, int val, int[] expectedNums) {
        int k = removeElement(nums, val); 

        assert k == expectedNums.length;
        sort(nums, 0, k); 
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
