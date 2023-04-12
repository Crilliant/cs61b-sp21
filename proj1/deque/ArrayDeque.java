package deque;

/**
 * @author crilliant
 */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int start;
    public ArrayDeque(){
        items = (T[])new Object[8];
        size = 0;
        start = 0;
    }

    public T get(int index){
        if (index > size || index < 0){
            return null;
        }
        // the transform index in items
        int transIdx = (start + index) % items.length;
        return items[transIdx];
    }
    public void addFirst(T x){
        if (size >= items.length){ // Need to resize the items Array.
            resize((int)(size * 1.1));
        }
        start = (start - 1 + items.length) % items.length; // 确保是正数
        size++;
        items[start] = x;
    }
    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            a[i] = items[(start + i) % items.length];
        }
        items = a;
    }
    public void addLast(T x){
        if (size >= items.length){ // Need to resize the items Array.
            resize((int)(size * 1.5));
        }
        int last = (start + size) % items.length;
        size++;
        items[last] = x;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size(){
        return size;
    }
    public void printDeque(){
        for(int i = 0; i < size; i++){
            System.out.print(items[(start + i) % items.length] + " ");
        }
    }
    public T removeFirst(){
        if ( size < 1){
            return null;
        }
        T old = items[start];
        items[start] = null;
        start = (start + 1) % items.length;
        size--;
        return old;
    }
    public T removeLast(){
        if ( size < 1){
            return null;
        }
        T old = items[(start + size - 1) % items.length];
        items[(start + size - 1) % items.length] = null;
        size--;
        return old;
    }
}
