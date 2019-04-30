package p07_CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        this.list.add(firstIndex + 1, this.list.get(secondIndex));
        T removedBoxes = this.list.remove(firstIndex);
        this.list.remove(secondIndex);
        this.list.add(secondIndex, removedBoxes);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T currVal : list) {
            if (compareTo(element, currVal)) {
                count++;
            }
        }
        return count;
    }

    public boolean compareTo(T comparedVal, T currVal) {
        if (currVal.compareTo(comparedVal) > 0) {
            return true;
        }
        return false;
    }

    public T getMax() {
        T firstVal = this.list.get(0);
        for (T currVal : this.list) {
            if (compareTo(firstVal, currVal)) {
                firstVal = currVal;
            }
        }
        return firstVal;
    }

    public T getMin() {
        T firstVal = this.list.get(0);
        for (T currVal : this.list) {
            if (!compareTo(firstVal, currVal)) {
                firstVal = currVal;
            }
        }
        return firstVal;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T currVal : this.list) {
            stringBuilder.append(currVal + "\n");
        }

        return stringBuilder + "";
    }

    public void sort() {
        this.list.sort(Comparable::compareTo);
    }



//     boolean compareTo(T comparedVal) {
//         if (this.input.compareTo(comparedVal) > 0) {
//             return true;
//         }
//         return false;
//     }

}


