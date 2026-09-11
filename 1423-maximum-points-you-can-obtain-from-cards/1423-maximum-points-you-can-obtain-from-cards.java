// class Solution {
//     public int maxScore(int[] cardPoints, int k) {
//         int maximum = 0;
//         int n = cardPoints.length;

//         for(int leftCards = 0 ; leftCards <= k ; leftCards++)
//         {
//             int rightCards = k - leftCards;
//             int sum = 0;
//             for(int i = 0 ; i < leftCards ; i++)
//             {
//                 sum += cardPoints[i];
//             }
//             for(int i = n - rightCards ; i < n ; i++)
//             {
//                 sum += cardPoints[i];
//             }
//             maximum = Math.max(maximum , sum);
//         }
//         return maximum;
//     }
// }

//optimize solution
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;
        int sum = 0;
        for(int num : cardPoints)
        {
            sum += num;
        }

        //finding sum of 1st window
        int windowSum = 0;
        for(int i = 0 ; i < windowSize ; i++)
        {
            windowSum += cardPoints[i];
        }
        int minWindowSum = windowSum;

        for(int right = windowSize ; right < n ; right++)
        {
            windowSum += cardPoints[right];
            windowSum -= cardPoints[right - windowSize];
            minWindowSum = Math.min(minWindowSum , windowSum);
        }
        return sum - minWindowSum;
    }
}

//used sliding window over here
