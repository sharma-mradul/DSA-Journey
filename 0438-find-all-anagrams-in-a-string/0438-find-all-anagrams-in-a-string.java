class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length())
        {
            return ans;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        //freq of p
        for(int i = 0 ; i < p.length() ; i++)
        {
            count1[p.charAt(i) - 'a']++;
        }        

        for(int i = 0 ; i < p.length() ; i++)
        {
            count2[s.charAt(i) - 'a']++;
        }

        //check
        if(Arrays.equals(count1 , count2))
        {
            ans.add(0);
        }

        //slide window
        for(int right = p.length() ; right < s.length() ; right++)
        {
            count2[s.charAt(right) - 'a']++;

            int left = right - p.length();
            count2[s.charAt(left) - 'a']--;

            if(Arrays.equals(count1 , count2))
            {
                ans.add(left + 1);
            }
        }
        return ans;
    }
}

// logic
// like first we check the base condition
// then we store frequency of p in count1
// we then take first window from s and store frequency in count2
// check weather first window is required solution or not
// then use sliding window to move further and check more window