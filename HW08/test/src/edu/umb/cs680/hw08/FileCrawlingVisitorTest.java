package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileCrawlingVisitorTest extends TestFixatureInitializer{


    @Test
    public void checkFileCrawlingVisitor() {

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        prjRoot.accept((FSVisitor) visitor);

        LinkedList<File> expectedFiles = new LinkedList<File>();
        expectedFiles.add(a);
        expectedFiles.add(b);
        expectedFiles.add(c);
        expectedFiles.add(d);
        expectedFiles.add(x);
        assertEquals(expectedFiles, visitor.getFiles());
    }
}
