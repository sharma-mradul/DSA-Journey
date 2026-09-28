class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i <= farthest)//can we reach index i
            {
                farthest = Math.max(farthest , nums[i] + i);

                if(farthest >= nums.length)
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}


//we have two choices weather we can go to next index i or not if not then we will return false , if yes which ultimately means that i is less than farthest then we will calculate new farthest and if farthest exced range which result that we can reach the last element of the array then we will return true