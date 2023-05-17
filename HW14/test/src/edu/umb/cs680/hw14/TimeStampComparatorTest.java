package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampComparatorTest extends TestFixatureInitializer{

    @Test
    public void getChildrenTimeStampSortedTest() {
        List<FSElement> alpha = List.of(y, x,  src, lib, test);
        //assertEquals(alpha, prjRoot.getChildren(new TimeStampComparator()));
        System.out.println(prjRoot.getChildren((obj1, obj2) -> obj1.getCreationTime().compareTo(obj2.getCreationTime())));
    }

    @Test
    public void getSubDirectoriesTimeStampSortedTest() {
        List<FSElement> alpha = List.of(src, lib, test);
        assertEquals(alpha, prjRoot.getSubDirectories((obj1, obj2) -> obj1.getCreationTime().compareTo(obj2.getCreationTime())));
    }

    @Test
    public void getFilesTimeStampSortedTest() {
        List<FSElement> alpha = List.of(a, b);
        assertEquals(alpha, src.getFiles((obj1, obj2) -> obj1.getCreationTime().compareTo(obj2.getCreationTime())));
    }
}