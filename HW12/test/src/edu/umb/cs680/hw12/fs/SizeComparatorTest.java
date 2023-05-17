package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.TestFixatureInitializer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SizeComparatorTest extends TestFixatureInitializer {


    @Test
    public void getChildrenSizeSortedTest() {
        List<FSElement> alpha = List.of(y, x,  src, lib, test);
        assertEquals(alpha, prjRoot.getChildren(new SizeComparator()));
        //System.out.println(prjRoot.getChildren(new AlphabeticalComparator()));
    }

    @Test
    public void getSubDirectoriesSizeSortedTest() {
        List<FSElement> alpha = List.of(src, lib, test);
        assertEquals(alpha, prjRoot.getSubDirectories(new SizeComparator()));
    }

    @Test
    public void getFilesSizeSortedTest() {
        List<FSElement> alpha = List.of(a, b);
        assertEquals(alpha, src.getFiles(new SizeComparator()));
    }
}