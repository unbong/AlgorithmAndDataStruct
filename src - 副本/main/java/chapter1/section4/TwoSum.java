package chapter1.section4;

import com.sun.deploy.util.StringUtils;
import utils.StopWatch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    private List<Integer> a = new ArrayList<>();

    public void twoSum()
    {
        StopWatch timeer = new StopWatch();
        BufferedReader reader = null;
        int count= 0;
        try {
            String s ;
            reader = new BufferedReader(new FileReader("src/main/resources/1Mints.txt"));
            while( (s = reader.readLine()) != null)
            {
                if(!s.trim().equals(""))
                    a.add(Integer.valueOf(s.trim()));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        a.sort(Integer::compareTo);

        for (int i = 0; i < a.size(); i++) {

            Integer b = a.get(i);

            Integer res = binarySearch(a, -b);
            if(res > i)
            {
                count++;
            }

        }
        System.out.print("count: " + count);
        System.out.println("time: " + timeer.elapsedTime());
    }

    private Integer binarySearch(List<Integer> list, Integer b)
    {
        int start = 0;
        int end = list.size();


         while(start < end)
        {
            int mid = start + (end-start) /2;
            if(list.get(mid).compareTo(b)>0)
            {
                end = mid;
            }
            else if(list.get(mid).compareTo(b)<0)
            {
                start = mid;
            }
            else {
                return mid;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        ts.twoSum();
    }

}
