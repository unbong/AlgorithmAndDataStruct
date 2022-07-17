package chapter1.section4;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Analyze1_4Test {

    public PrintStream StdOut()
    {
        return System.out;
    }

    @Test
    void threeSumFaster() {
    }

    @Test
    void findClosestPair() {
        Analyze1_4 analyze1_4 = new Analyze1_4();
        double[] array1 = {-5.2, 9.4, 20, -10, 21.1, 40, 50, -20};
        double[] array2 = {-4, -3, 0, 10, 20};
        double[] array3 = {-10, -3, 0, 2, 4, 20};

        List<Double> d1 = DoubleStream.of(array1).boxed().collect(Collectors.toList());
        List<Double> d2 = DoubleStream.of(array2).boxed().collect(Collectors.toList());
        List<Double> d3 = DoubleStream.of(array3).boxed().collect(Collectors.toList());



        Double[] closestPair1 = analyze1_4.findClosestPair(d1);
        Double[] closestPair2 = analyze1_4.findClosestPair(d2);
        Double[] closestPair3 = analyze1_4.findClosestPair(d3);

        System.out.println("Closest pair: " + closestPair1[0] + " " + closestPair1[1] + " Expected: 20.0 21.1");
        System.out.println("Closest pair: " + closestPair2[0] + " " + closestPair2[1] + " Expected: -4.0 -3.0");
        System.out.println("Closest pair: " + closestPair3[0] + " " + closestPair3[1] + " Expected: 0.0 2.0");
    }

    @Test
    void findXInDouble() {
        Analyze1_4 analyze1_4 = new Analyze1_4();
        int[] array1 = {1, 2, 3, 4, -1, -2, -3};
        int[] array2 = {1, 5, 4, 3, 2, 0};
        int[] array3 = {2, 4, 8, 16, 32, 1};
        int[] array4 = {2, 4, 8, 16, 32};
        int[] array5 = {2, 1};
        int[] array6 = {9};

        List<Integer> a1 = Arrays.stream(array1).boxed().collect(Collectors.toList());
        List<Integer> a2 = Arrays.stream(array2).boxed().collect(Collectors.toList());
        List<Integer> a3 = Arrays.stream(array3).boxed().collect(Collectors.toList());
        List<Integer> a4 = Arrays.stream(array4).boxed().collect(Collectors.toList());
        List<Integer> a5 = Arrays.stream(array5).boxed().collect(Collectors.toList());
        List<Integer> a6 = Arrays.stream(array6).boxed().collect(Collectors.toList());


        int indexOfElement1 = analyze1_4.binaryFind_4_20(a1, -1);
        int indexOfElement2 = analyze1_4.binaryFind_4_20(a2, 5);
        int indexOfElement3 = analyze1_4.binaryFind_4_20(a3, 2);
        int indexOfElement4 = analyze1_4.binaryFind_4_20(a3, 99);
        int indexOfElement5 = analyze1_4.binaryFind_4_20(a4, 32);
        int indexOfElement6 = analyze1_4.binaryFind_4_20(a5, 1);
        int indexOfElement7 = analyze1_4.binaryFind_4_20(a6, 9);

        System.out.println("Index of element: " + indexOfElement1 + " Expected: 4");
        System.out.println("Index of element: " + indexOfElement2 + " Expected: 1");
        System.out.println("Index of element: " + indexOfElement3 + " Expected: 0");
        System.out.println("Index of element: " + indexOfElement4 + " Expected: -1");
        System.out.println("Index of element: " + indexOfElement5 + " Expected: 4");
        System.out.println("Index of element: " + indexOfElement6 + " Expected: 1");
        System.out.println("Index of element: " + indexOfElement7 + " Expected: 0");
    }

    @Test
    void fibonacciBinarySearch() {
        int[] array = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7};

        List<Integer> a1 = Arrays.stream(array).boxed().collect(Collectors.toList());
        Analyze1_4 analyze1_4 = new Analyze1_4();
        int index1 = analyze1_4.fibonacciBinarySearch(a1, 2);
        int index2 = analyze1_4.fibonacciBinarySearch(a1, 9);
        int index3 = analyze1_4.fibonacciBinarySearch(a1, -3);
        int index4 = analyze1_4.fibonacciBinarySearch(a1, 7);
        int index5 = analyze1_4.fibonacciBinarySearch(a1, -2);

        System.out.println("Is element in the array: " + (index1 != -1) + " Expected: true");
        System.out.println("Is element in the array: " + (index2 != -1) + " Expected: false");
        System.out.println("Is element in the array: " + (index3 != -1) + " Expected: false");
        System.out.println("Is element in the array: " + (index4 != -1) + " Expected: true");
        System.out.println("Is element in the array: " + (index5 != -1) + " Expected: true");

    }
}