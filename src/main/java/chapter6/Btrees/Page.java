package chapter6.Btrees;

import chapter3.BinarySearchST;
import chapter3.Section5.Ex1_HashSet;
import chapter6.Btrees.Interface.PageInterface;
import edu.princeton.cs.algs4.StdOut;

import java.util.StringJoiner;


/**
 * todo 未完成
 * 可参考 https://github.com/tclxspy/Articles/blob/master/algorithm/MD/%E7%AE%97%E6%B3%95%2316--B%E6%A0%91%E5%AE%8C%E6%95%B4%E4%BB%A3%E7%A0%81Java%E5%AE%9E%E7%8E%B0.md
 * @param <Key>
 */
public class Page<Key extends Comparable<Key>> implements PageInterface<Key> {

    private class PageValue{
        private PageInterface<Key> childPage;

        PageValue(PageInterface<Key> childPage){
            this.childPage = childPage;
        }
    }

    private BinarySearchST<Key, PageValue> binarySearchSymbolTable;
    private boolean isOpen;
    private boolean isExternal;
    private boolean verbose;

    private Ex1_HashSet<PageInterface> pagesInMemory;
    private int maxNumberOfNodes;


    Page(boolean bottom, int maxNumberOfNodes, Ex1_HashSet<PageInterface> pagesInMemory){
        if(maxNumberOfNodes == 2 || maxNumberOfNodes % 2 != 0){
            throw new IllegalArgumentException("Max number of nodes must be divisible by 2 and higher than 2");
        }

        binarySearchSymbolTable = new BinarySearchST<>();
        this.pagesInMemory = pagesInMemory;
        this.maxNumberOfNodes = maxNumberOfNodes;
        isExternal = bottom;
        verbose = true;
        open();
    }


    private void open(){
        pagesInMemory.add(this);
        isOpen = true;
    }

    /**
     * 关闭页
     */
    @Override
    public void close() {
        StringJoiner pageContent = new StringJoiner(" ");

        for(Key key: keys()){
            pageContent.add(String.valueOf(key));
        }

        if(verbose)
            StdOut.println("Page Content:" + pageContent.toString());

        pagesInMemory.delete(this);
        isOpen = false;
    }

    @Override
    public PageInterface getPage(Key key) {

        return null;
    }

    @Override
    public void add(Key key) {

    }

    @Override
    public void add(PageInterface<Key> page) {

    }

    @Override
    public boolean isExternal() {
        return false;
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public PageInterface<Key> next(Key key) {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public PageInterface<Key> split() {
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public int getMaxNumberOfNodes() {
        return 0;
    }

    @Override
    public void setVerbose(boolean verbose) {

    }
}
