package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> c;
    /**
     * creates a MaxArrayDeque with the given Comparator
     * @param c
     */
    public MaxArrayDeque(Comparator<T> c){
        this.c = c;
    }
    public MaxArrayDeque(){ }

    /**
     * @return the maximum element in the deque.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public T max(){
        return max(c);
    }

    /**
     * @param c
     * @return The maximum element in the deque as governed by the parameter Comparator c
     *          If the MaxArrayDeque is empty, simply return null.
     */
    public T max(Comparator<T> c){
        T max = (T) get(0);
        for (int i = 1; i < size(); i++){
            if(c.compare(max, (T)get(i)) < 0){
                max = (T)get(i);
            }
        }
        return max;
    }

}
