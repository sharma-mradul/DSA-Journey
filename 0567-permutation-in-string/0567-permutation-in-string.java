import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
        {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0 ; i < s1.length() ; i++)
        {
            count1[s1.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < s1.length() ; i++)
        {
            count2[s2.charAt(i) - 'a']++;
        }
        //checking
        if(Arrays.equals(count1 , count2))
        {
            return true;
        }

        for(int right = s1.length() ; right < s2.length() ; right++)
        {
            count2[s2.charAt(right) - 'a']++;

            int left = right - s1.length();
            count2[s2.charAt(left) - 'a']--;
            if(Arrays.equals(count1 , count2))
            {
                return true;
            }
        }
        return false;
    }
}


//another checking way using for loop
// boolean same = true;
// for(int i = 0 ; i < 26 ; i++)
// {
//     if(count1[i] != count2[i])
//     {
//         same = false;
//         break;
//     }
// }
// if(same)
// {
//     return true;
// }