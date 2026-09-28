class Solution {
    public int jump(int[] nums) {

        int farthest = 0;
        int range = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (range == i) {
                count++;
                range = farthest;
            }
        }
        return count;
    }
}