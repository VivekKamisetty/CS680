package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {

    @Override
        public int compare(FSElement o1, FSElement o2) {
            LocalDateTime o1CreationTime = o1.getCreationTime();
        LocalDateTime o2CreationTime = o2.getCreationTime();
        return o1CreationTime.compareTo(o2CreationTime);
    }
}
