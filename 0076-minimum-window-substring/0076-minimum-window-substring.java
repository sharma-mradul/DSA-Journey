// class Solution {
//     public String minWindow(String s, String t) {
//         int m = s.length();
//         int n = t.length();
//         int minLength = Integer.MAX_VALUE;
//         int start = 0;
//         int left = 0;

//         //checking starting base case
//         if(n > m)
//         {
//             return "";
//         }

//         //creating array for frequency
//         int[] count1 = new int[128];
//         int[] count2 = new int[128];

//         //frequency of child string t
//         for(int i = 0 ; i < n ; i++)
//         {
//             count1[t.charAt(i)]++;
//         }

//         for(int right = 0 ; right < m ; right++)
//         {
//             count2[s.charAt(right)]++;

//             //checking main 
//             boolean valid = true;
//             for(int i = 0 ; i < n ; i++)
//             {
//                 char ch = t.charAt(i);
//                 if(count2[ch] < count1[ch])
//                 {
//                     valid = false;
//                     break;
//                 }
//             }
//             //if valid 
//             while(valid)
//             {
//                 if(right - left + 1 < minLength)
//                 {
//                     minLength = right - left + 1;
//                     start = left;
//                 }
//                 //remov left char
//                 count2[s.charAt(left)]--;
//                 left++;

//                 //check again
//                 for(int i = 0 ; i < n ; i++)
//                 {
//                     char ch = t.charAt(i);
//                     if(count2[ch] < count1[ch])
//                     {
//                         valid = false;
//                         break;
//                     }
//                 }
//             }
//         }
//         if(minLength == Integer.MAX_VALUE)
//         {
//                     return "";
//         }
//         return s.substring(start , start + minLength);
//     }
// }


// how we solve this 
// 1.checked the base case
// 2.array creation for storing frequency of size 128 , like the safe limit is 123 but like for cleanliness we use 128 as it is power of 2 also
// 3.count frequency of child string t
// 4.placing an outer for loop for parent string s 
//   we count the characters from right like one by one adding and checking weather they are valid or not if valid then start to shrink them from left using while loop and like storing the length the valid length everytime in the starting of while loop in minLength , we remove in while loop basically store valid Length then shrink the check if invalid then out of while loop and goes to outer for loop to add character from right , whereas if valid then keep on shrinking from left in while loop\
// 5.uses initial minLength condition to check weather any substring was being found 
//   or not
// 6.return s.substring(start , start + minLength) , the start is starting from valid
//   left 
//7.O(m*n)


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

        int need = 0;
        for(int i = 0 ; i < 128 ; i++)
        {
            if(count1[i] > 0)
            {
                need++;
            }
        }
        int have = 0;

        for(int right = 0 ; right < m ; right++)
        {
            char ch = s.charAt(right);
            count2[ch]++;

            if(count1[ch] > 0 && count2[ch] ==count1[ch])
            {
                have++;
            }

            while(have == need)
            {
                if(right - left + 1 < minLength)
                {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                count2[leftChar]--;

                if(count1[leftChar] > 0 && count2[leftChar] < count1[leftChar])
                {
                    have--;
                }
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE)
        {
            return "";
        }
        return s.substring(start , start + minLength);
    }
}
//this is optimize solution with improved complexity from O(m*n) to O(m + n)