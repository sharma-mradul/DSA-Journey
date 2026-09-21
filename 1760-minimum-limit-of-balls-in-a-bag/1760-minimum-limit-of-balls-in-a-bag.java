class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for(int num : nums)
        {
            right = Math.max(right , num);
        }

        while(left < right)
        {
            int mid = left + (right - left) / 2;
            int c = 0;

            for(int num : nums)
            {
                c += (num - 1) / mid;
            }
            if(c <= maxOperations)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }
}
