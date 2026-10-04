class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = new int[nums1.length + nums2.length];
        int j = 0;
        for(int i = 0 ; i < nums1.length ; i++)
        {
            merged[i] = nums1[i];
            j++;
        }

        for(int i = 0 ; i < nums2.length ; i++)
        {
            merged[j] = nums2[i];
            j++;
        }

        Arrays.sort(merged);

        int n = merged.length;

        if (n % 2 == 1) {
            return merged[n / 2];
        } 
        else {
        return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        }
    }
}