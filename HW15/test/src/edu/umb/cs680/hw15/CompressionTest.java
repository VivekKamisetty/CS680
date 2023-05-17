package edu.umb.cs680.hw15;

import edu.umb.cs680.hw15.fs.Directory;
import edu.umb.cs680.hw15.fs.File;
import edu.umb.cs680.hw15.zip_algo.GzipCompressionStrategy;
import edu.umb.cs680.hw15.zip_algo.RarCompressionStrategy;
import edu.umb.cs680.hw15.zip_algo.ZipCompressionStrategy;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CompressionTest {
    @Test
    public void testCompression() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Directory prjRoot = new Directory(null, "prjRoot", 100, localDateTime);
        Directory src = new Directory(prjRoot, "src", 100, localDateTime);
        Directory lib = new Directory(prjRoot, "lib", 100, localDateTime);
        Directory test = new Directory(prjRoot, "test", 100, localDateTime);
        Directory testSrc = new Directory(test, "src", 100, localDateTime);

        File a = new File(src, "a", 25, localDateTime);
        File b = new File(src, "b", 25, localDateTime);
        File c = new File(lib, "c", 25, localDateTime);
        File d = new File(testSrc, "d", 25, localDateTime);
        File x = new File(prjRoot, "x", 25, localDateTime);
        File file = new File(prjRoot, "file.txt", 25, localDateTime);
        // create test file

        CompressionClient client = new CompressionClient(new ZipCompressionStrategy());
        client.compressFile(file);

        client.setCompressionStrategy(new GzipCompressionStrategy());
        client.compressFile(file);

        client.setCompressionStrategy(new RarCompressionStrategy());
        client.compressFile(file);
    }
}