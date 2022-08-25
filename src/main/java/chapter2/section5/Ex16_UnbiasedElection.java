package chapter2.section5;

import org.jetbrains.annotations.NotNull;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class Ex16_UnbiasedElection {


    private class CandidateOrder implements Comparator<String>
    {

        private String order = "RWQOJMVAHBSGZXNTCIEKUPDYFL";


        @Override
        public int compare(String o1, String o2) {
            char c1 = o1.charAt(0);
            char c2 = o2.charAt(0);

            if(order.indexOf(c1)< order.indexOf(c2)) return -1;
            else if(order.indexOf(c1)> order.indexOf(c2)) return 1;
            return 0;
        }
    }

    private void california(){
        String candidate1 = "RENE";
        String candidate2 = "LAST CANDIDATE";
        String candidate3 = "VIP";
        String candidate4 = "VIP 2";
        String candidate5 = "ZORD";
        String candidate6 = "OBAMA";
        String candidate7 = "TRUMP";
        String candidate8 = "TRYMP";

        String candidates[] = {candidate1,candidate2,candidate3,candidate4,candidate5,
                candidate6, candidate7, candidate8};

        Arrays.sort(candidates, new CandidateOrder());
        ArrayUtils.show(candidates);
    }

    public static void main(String[] args) {
       new Ex16_UnbiasedElection().california();
    }
}
