package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement obj1, FSElement obj2) {
        int size1 = obj1.getSize();
        int size2 = obj2.getSize();
        if (size1 < size2) {
            return -1;
        } else if (size1 > size2) {
            return 1;
        } else {
            return 0;
        }
    }
}
