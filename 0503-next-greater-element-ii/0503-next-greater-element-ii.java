class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] answer = new int[nums.length];
        for(int i = 0 ; i < answer.length ; i++)
        {
            answer[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            while(!st.isEmpty() && nums[i] > nums[st.peek()])
            {
                int pos = st.pop();
                answer[pos] = nums[i];
            }
            st.push(i);
        }

        for(int i = 0 ; i < nums.length ; i++)
        {
            while(!st.isEmpty() && nums[i] > nums[st.peek()])
            {
                int pos = st.pop();
                answer[pos] = nums[i];
            }
        }
        return answer;
    }
}