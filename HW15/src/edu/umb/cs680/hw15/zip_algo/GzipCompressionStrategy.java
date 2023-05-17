package edu.umb.cs680.hw15.zip_algo;

import edu.umb.cs680.hw15.CompressionStrategy;
import edu.umb.cs680.hw15.fs.File;

public class GzipCompressionStrategy implements CompressionStrategy {
    @Override
    public void compress(File file) {
        System.out.println("Compressing " + file.getName() + " using GzipCompression.");

    }
}
