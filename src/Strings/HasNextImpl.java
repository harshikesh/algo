package Strings;

/**
 * Created by harshikesh.kumar on 03/06/16.
 */
public class HasNextImpl {
    int current = 0;
    int find = 0;
    int arr[];
    int size = arr.length;

    public boolean hasNext() {

        for (int i = current; i < size; i++) {
            if (arr[i] % 2 != 0) {
                find = i;
                return true;
            }
        }
        return false;
    }

    public int Next() {
        if (hasNext()) {
            current = find;
            return arr[find];
        }
        return -1;
    }

}
