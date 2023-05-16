package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;
import edu.umb.cs680.hw08.fs.util.CountingVisitor;
import edu.umb.cs680.hw08.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CountingVisitorTest extends TestFixatureInitializer{
    

    @Test
    public void checkCountingVisitorFile() {
        CountingVisitor visitor = new CountingVisitor();
        prjRoot.accept(visitor);
        assertEquals(5, visitor.getFileCount());
    }

    @Test
    public void checkCountingVisitorDir() {
        CountingVisitor visitor = new CountingVisitor();
        prjRoot.accept(visitor);
        assertEquals(5, visitor.getDirCount());
    }

    @Test
    public void checkCountingVisitorLink() {
        CountingVisitor visitor = new CountingVisitor();
        prjRoot.accept(visitor);
        assertEquals(1, visitor.getLinkCount());
        assertTrue(y.isLink());

    }
}
