class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] count = new int[26];
        int maxFreq = 0;
        int maximum = 0;

        for(int right = 0 ; right < s.length() ; right++)
        {
            char ch = s.charAt(right);
            int value = ch - 'A';
            count[value]++;

            maxFreq = Math.max(maxFreq , count[value]);

            while((right - left + 1) - maxFreq > k)
            {
                char leftChar = s.charAt(left);
                int leftValue = leftChar - 'A';
                count[leftValue]--;
                left++;

                //recalculating maxFreq
                maxFreq = 0;
                for(int i = 0 ; i < 26 ; i++)
                {
                    maxFreq = Math.max(maxFreq , count[i]);
                }
            }
            maximum = Math.max(maximum , right - left + 1);
        }
        return maximum;
    }
}


// LOGIC
// for()
// {
//     find maxFreq
//     checking for validness while(){
//         shrink from left side
//         recalculate max freq
//     }
//     find maximum length of valid thing
// }