//the brute force is partially correct like the main problem is of the length
// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         int[] count2 = new int[10];

//         int c = 0;
//         int have = 0;
//         for(int i = 0 ; i < nums.length ; i++)
//         {
//             have = 0;
//             for(int d = 0 ; d < count2.length ; d++)
//             {
//                 count2[d] = 0;
//             }
//             for(int j = i ; j < nums.length ; j++)
//             {
//                 int val = nums[j];
//                 if(count2[val] == 0)
//                 {
//                     have++;
//                     count2[val]++;
//                 }
//                 if(have == k)
//                 {
//                     c++;
//                 }
//             }
//         }
//         return c;
//     }
// }
//the brute force is partially correct 


//optimize solution is followed
class Solution {
     public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums , k) - atMost(nums , k - 1);
     }
    
        //creating a helper
    public int atMost(int[] nums , int k)
    {
        int[] freq = new int[100001];
        int left = 0;
        int distinct = 0;
        int count = 0;

        for(int right = 0 ; right < nums.length ; right++)
        {
            if(freq[nums[right]] == 0)
            {
                distinct++;
            }
            freq[nums[right]]++;

            while(distinct > k)
            {
                freq[nums[left]]--;
                if(freq[nums[left]] == 0)
                {
                    distinct--;
                }
                left++;
            }
        count += right - left + 1;
        }
        return count;     
    }
}


// look like we have to find the subarrays with k integers , like we can find it by subtracting it with one less then it 
// ex k = 3 it consists of distinct[1] + distinct[2] + distinct[3] , like k = 2 consists of distinct[2] + distinct[3]  , so sub them will give distinct[3] , in counting we use approach like brute force 