import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < temperatures.length ; i++)
        {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()])
            {
                int previousIndex = st.pop();
                answer[previousIndex] = i - previousIndex;
            }
            st.push(i);
        }
        return answer;
    }
}

//like we take one array and one stack , like we place an outer for loop from i to length then check in while loop weather stack is not empty and if current temp is more then stack.peek() then previous index = stack.pop() and answer[previousindex] = i - previousIndex , then push (i)