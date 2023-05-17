package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    private Directory parent;

    FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
//        System.out.println(this.creationTime);

    }

    public Directory getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        System.out.println(this.creationTime);
        return this.creationTime;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();

    public abstract void accept(FSVisitor v);
}