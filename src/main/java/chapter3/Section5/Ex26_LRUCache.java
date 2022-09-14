package chapter3.Section5;

import chapter1.section3.DoubleLinkedList;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * LRU缓存 创建一个支持以下操作的数据结构：访问和删除。
 * 访问操作会将不存在于数据结构中的元素插入。删除操作会删除并返回最近最少访问的元素。
 */
public class Ex26_LRUCache<Item> {

    private TreeMap<Item, DoubleLinkedList.DoubleNode> st;
    private DoubleLinkedList<Item> list;

    public Ex26_LRUCache(){
        st = new TreeMap<>();
        list = new DoubleLinkedList<>();
    }

    public void get(Item item){
        if(st.containsKey(item)){
            list.removeItemWithNode(st.get(item));
            st.remove(item);
        }
        list.insertAtTheBeginning(item);
        st.put(item, list.getFirstNode());

    }

    public Item delete(Item item){
        Item leastRecentlyAccessedItem = list.removeFromTheEnd();

        if (leastRecentlyAccessedItem != null) {
            st.remove(leastRecentlyAccessedItem);
        }

        return leastRecentlyAccessedItem;
    }
}

