class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;

        //checking starting base case
        if(n > m)
        {
            return "";
        }

        //creating array for frequency
        int[] count1 = new int[128];
        int[] count2 = new int[128];

        //frequency of child string t
        for(int i = 0 ; i < n ; i++)
        {
            count1[t.charAt(i)]++;
        }

        for(int right = 0 ; right < m ; right++)
        {
            count2[s.charAt(right)]++;

            //checking main 
            boolean valid = true;
            for(int i = 0 ; i < n ; i++)
            {
                char ch = t.charAt(i);
                if(count2[ch] < count1[ch])
                {
                    valid = false;
                    break;
                }
            }
            //if valid 
            while(valid)
            {
                if(right - left + 1 < minLength)
                {
                    minLength = right - left + 1;
                    start = left;
                }
                //remov left char
                count2[s.charAt(left)]--;
                left++;

                //check again
                for(int i = 0 ; i < n ; i++)
                {
                    char ch = t.charAt(i);
                    if(count2[ch] < count1[ch])
                    {
                        valid = false;
                        break;
                    }
                }
            }
        }
        if(minLength == Integer.MAX_VALUE)
        {
                    return "";
        }
        return s.substring(start , start + minLength);
    }
}


