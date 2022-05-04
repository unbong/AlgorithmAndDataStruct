package stack;

public interface Stack<T> {
    T pop();
    T top();
    void push(T val);
    int size();
    boolean isEmpty();
    boolean isFull();
}
