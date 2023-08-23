package neetcode150.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarFleet_853 {

    class node{
        public node(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
        int position;
        int speed;
    }

    public int carFleet(int target, int[] position, int[] speed) {

        int res = 0;
        List<node> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new node(position[i], speed[i]));
        }

        list.sort((first, second)-> second.position- first.position);

        Stack<Double> st = new Stack<>();
        for(node n: list){
            if(st.isEmpty()) {
                st.push(((double)target-(double)n.position)/(double)n.speed);
            }
            else {
                double time = ((double)target-(double)n.position)/(double)n.speed;
                if(st.peek()>=time){
                    st.push(st.peek());
                }
                else {
                    res++;
                    while(!st.isEmpty()) st.pop();
                    st.push(time);
                }
            }
        }

        if(!st.isEmpty()) res++;

        return res;

    }

}
