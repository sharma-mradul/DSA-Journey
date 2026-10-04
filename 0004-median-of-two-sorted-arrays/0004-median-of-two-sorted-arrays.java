// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {

//         int[] merged = new int[nums1.length + nums2.length];
//         int j = 0;
//         for(int i = 0 ; i < nums1.length ; i++)
//         {
//             merged[i] = nums1[i];
//             j++;
//         }

//         for(int i = 0 ; i < nums2.length ; i++)
//         {
//             merged[j] = nums2[i];
//             j++;
//         }

//         Arrays.sort(merged);

//         int n = merged.length;

//         if (n % 2 == 1) {
//             return merged[n / 2];
//         } 
//         else {
//         return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
//         }
//     }
// }



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2 , nums1);
        }

        int left = 0;
        int right = nums1.length;

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int leftSize = (total + 1) / 2;

        while(left <= right)
        {
            int partition1 = left + (right - left) / 2;

            int partition2 = leftSize - partition1;

            int A , B , C , D;

            if(partition1 == 0)
            {
                A = Integer.MIN_VALUE;
            }
            else{
                A = nums1[partition1 - 1];
            }

            B = (partition1 == m)? Integer.MAX_VALUE : nums1[partition1] ;

            C = (partition2 == 0)? Integer.MIN_VALUE : nums2[partition2 - 1];

            D = (partition2 == n)? Integer.MAX_VALUE : nums2[partition2] ;

            if(A <= D && C <= B)
            {

                //ODD
                if(total % 2 == 1)
                {
                    return Math.max(A , C);
                }
                else{
                    return (Math.max(A , C) + Math.min(B , D)) / 2.0;
                }
            }

            if(A > D)
            {
                right = partition1 - 1;
            }
            else{
                left = partition1 + 1;
            }
        }
        return 0.0;
    }
}