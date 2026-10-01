class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i = 0 ; i <= heights.length ; i++)
        {
            int currentHeight;

            if(i == heights.length)
            {
                currentHeight = 0;
            }
            else
            {
                currentHeight = heights[i];
            }

            while(!st.isEmpty() && currentHeight < heights[st.peek()])
            {
                int pos = st.pop();
                int height = heights[pos];
                int right = i;
                int left;

                if(st.isEmpty())
                {
                    left = -1;
                }
                else
                {
                    left = st.peek();
                }
                int width = right - left - 1;
                int area = height * width;
                maxArea = Math.max(maxArea , area);
            }
            st.push(i);
        }
        return maxArea;
    }
}