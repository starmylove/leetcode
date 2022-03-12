package middle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class num_284  implements Iterator<Integer>{
    List<Integer> list = new ArrayList<>();
    int ptr = 0 , size;
    public num_284(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        size = list.size();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(ptr < size) {
            return list.get(ptr);
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(ptr++);
    }

    @Override
    public boolean hasNext() {
        return !(ptr==size);
    }
}
