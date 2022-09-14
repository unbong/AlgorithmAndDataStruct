package chapter3.Section5;

import chapter1.section3.DoubleLinkedList;
import chapter3.SeparateChainingHashST;

public class Ex27_List <Item>{

    private DoubleLinkedList<Item> list;
    private SeparateChainingHashST<Integer, DoubleLinkedList<Item>.DoubleNode> indexSt;
    private SeparateChainingHashST<Item, DoubleLinkedList<Item>.DoubleNode> valSt;
    private int size;

    public Ex27_List(){

    }


}
