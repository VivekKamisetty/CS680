package edu.umb.cs680.hw14;

import java.time.LocalDateTime;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.FileSystem;
import edu.umb.cs680.hw14.fs.Link;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFixatureInitializer {

    protected Directory prjRoot;
    protected Directory src;
    protected Directory lib;
    protected Directory test;
    protected Directory testSrc;
    protected FileSystem fileSystem;

    protected File a;
    protected File b;
    protected File c;
    protected File d;
    protected File x;
    protected Link y;

    @BeforeAll
    public void setUp() {
        LocalDateTime localDateTime = LocalDateTime.now();

        fileSystem = FileSystem.getFileSystem();

        prjRoot = new Directory(null, "prjRoot", 100, localDateTime);
        src = new Directory(prjRoot, "src", 100, localDateTime);
        lib = new Directory(prjRoot, "lib", 100, localDateTime);
        test = new Directory(prjRoot, "test", 100, localDateTime);
        testSrc = new Directory(test, "src", 100, localDateTime);

        a = new File(src, "a", 25, localDateTime);
        b = new File(src, "b", 25, localDateTime);
        c = new File(lib, "c", 25, localDateTime);
        d = new File(testSrc, "d", 25, localDateTime);
        x = new File(prjRoot, "x", 25, localDateTime);

        y = new Link(prjRoot, "y", 0, localDateTime, d);



    }

}