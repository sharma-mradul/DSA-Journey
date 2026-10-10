class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        int sum = 0;

        for(int i = 0 ; i < nums.length - 2 ; i++)
        {
            int left = i+1;
            int right = nums.length - 1;

            while(left < right)
            {
                sum = nums[i] + nums[left] + nums[right];

                //checking for the closest
                if(Math.abs(sum - target) < Math.abs(closeSum - target))
                {
                    closeSum = sum;
                }
                if(target < sum)
                {
                    right--;
                }
                else if(target > sum)
                {
                    left++;
                }
                else
                {
                    return sum;
                }
            }
        }
        return closeSum;
    }
}