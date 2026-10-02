class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long answer = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i <= n ; i++)
        {
            int current;
            if(i == n)
            {
                current = 0;
            }
            else
            {
                current = arr[i];
            }

            while(!st.isEmpty() && current < arr[st.peek()])
            {
                int pos = st.pop();

                int left;
                if(st.isEmpty())
                {
                    left = -1;
                }
                else
                {
                    left = st.peek();
                }

                int right = i;

                long leftWays = pos - left;
                long rightWays = right - pos;

                answer += (long)arr[pos] * leftWays * rightWays;
            }
            st.push(i);
        }
        return (int)(answer % 1000000007);
    }
}