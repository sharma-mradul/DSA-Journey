import java.util.*;
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int left = 0;
        int maximum = 0;

        for(int right = 0 ; right < fruits.length ; right++)
        {
            if(map.containsKey(fruits[right]))
            {
                map.put(fruits[right] , map.get(fruits[right]) + 1);
            }
            else
            {
                map.put(fruits[right] , 1);
            }

            while(map.size() > 2)
            {
                int fruit = fruits[left];
                map.put(fruit , map.get(fruit) - 1);
                if(map.get(fruit) == 0)
                {
                    map.remove(fruit);
                }
                left++;
            }
            maximum = Math.max(maximum , right - left + 1);
        }
        return maximum;
    }
}


//