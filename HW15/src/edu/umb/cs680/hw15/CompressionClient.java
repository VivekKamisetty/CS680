package edu.umb.cs680.hw15;

import edu.umb.cs680.hw15.fs.File;

public class CompressionClient {
    private CompressionStrategy strategy;

    public CompressionClient(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compressFile(File file) {
        strategy.compress(file);
    }
}
