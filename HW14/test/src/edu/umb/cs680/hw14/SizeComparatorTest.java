package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SizeComparatorTest extends TestFixatureInitializer{

    @Test
    public void getChildrenSizeSortedTest() {
        List<FSElement> alpha = List.of(y, x,  src, lib, test);
        assertEquals(alpha, prjRoot.getChildren((obj1, obj2) -> Integer.compare(obj1.getSize(), obj2.getSize())));
        //System.out.println(prjRoot.getChildren(new AlphabeticalComparator()));
    }

    @Test
    public void getSubDirectoriesSizeSortedTest() {
        List<FSElement> alpha = List.of(src, lib, test);
        assertEquals(alpha, prjRoot.getSubDirectories((obj1, obj2) -> Integer.compare(obj1.getSize(), obj2.getSize())));
    }

    @Test
    public void getFilesSizeSortedTest() {
        List<FSElement> alpha = List.of(a, b);
        assertEquals(alpha, src.getFiles((obj1, obj2) -> Integer.compare(obj1.getSize(), obj2.getSize())));
    }
}