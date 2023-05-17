package edu.umb.cs680.hw15;

import edu.umb.cs680.hw15.fs.File;

public interface CompressionStrategy {
    void compress(File file);
}
