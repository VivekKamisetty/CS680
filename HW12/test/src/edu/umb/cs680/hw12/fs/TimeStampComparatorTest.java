package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.TestFixatureInitializer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampComparatorTest extends TestFixatureInitializer {

    @Test
    public void getChildrenTimeStampSortedTest() {
        List<FSElement> alpha = List.of(src, lib, test, x, y);
        assertEquals(alpha, prjRoot.getChildren(new TimeStampComparator()));
        //System.out.println(prjRoot.getChildren(new TimeStampComparator()));
    }

    @Test
    public void getSubDirectoriesTimeStampSortedTest() {
        List<FSElement> alpha = List.of(src, lib, test);
        assertEquals(alpha, prjRoot.getSubDirectories(new TimeStampComparator()));
    }

    @Test
    public void getFilesTimeStampSortedTest() {
        List<FSElement> alpha = List.of(a, b);
        assertEquals(alpha, src.getFiles(new TimeStampComparator()));
    }
}