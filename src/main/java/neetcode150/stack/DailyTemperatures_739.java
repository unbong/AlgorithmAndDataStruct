package neetcode150.stack;

import java.util.Stack;

public class DailyTemperatures_739 {

    class node{
        public node(int index, int temp){
            this.index = index;
            this.temp = temp;
        }
        int index;
        int temp;
    }

    /**
     *
     * 1 在遍历时将单调递减的信息保存在栈数据结构中，当遇到比栈中数据大的数据时，将比元素小的元素从栈中取出，并获取两个数之间的索引差值。
     *
     *
     * 2 可以使用穷举的方法，时间复杂读为O（n^2)
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<node> st = new Stack<>();
        int [] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            if(st.isEmpty())
            {
                st.push(new node(i, t));
            }
            else{
                if(st.peek().temp < t){
                    while(!st.isEmpty() && st.peek().temp < t){
                        res[st.peek().index] = i - st.peek().index;
                        st.pop();

                    }
                    st.push(new node(i, t));
                }
                else{
                    st.push(new node(i, t));

                }
            }

        }


        while(!st.isEmpty())
        {
            res[st.peek().index] = 0;
            st.pop();
        }

        return res;
    }
}
