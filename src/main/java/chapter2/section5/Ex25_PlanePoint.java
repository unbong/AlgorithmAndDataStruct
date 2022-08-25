package chapter2.section5;

import java.util.Comparator;

public class Ex25_PlanePoint {

    private double _x;
    private double _y;

    public Ex25_PlanePoint(double x, double y)
    {
        _x = x;
        _y = y;

    }


    private static class XOrder implements Comparator<Ex25_PlanePoint>{

        @Override
        public int compare(Ex25_PlanePoint o1, Ex25_PlanePoint o2) {
            double cmp = o1._x*o1._x - o2._x*o2._x;
            if(cmp > 0) return 1;
            else if(cmp <0) return -1;

            return 0;
        }
    }

    private static class YOrder implements Comparator<Ex25_PlanePoint>{

        @Override
        public int compare(Ex25_PlanePoint o1, Ex25_PlanePoint o2) {
            double cmp = o1._y*o1._y - o2._y*o2._y;
            if(cmp > 0) return 1;
            else if(cmp <0) return -1;

            return 0;
        }
    }


    private static class OriginOrder implements Comparator<Ex25_PlanePoint>{

        @Override
        public int compare(Ex25_PlanePoint o1, Ex25_PlanePoint o2) {
            double cmp = o1._x*o1._x + o1._y*o1._y - o2._x*o2._x + o2._y*o2._y;
            if(cmp > 0) return 1;
            else if(cmp <0) return -1;

            return 0;
        }
    }


}
