package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        // TODO Auto-generated constructor stub
        this.target = target;
        parent.appendChild(this);
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

    public FSElement getTarget() {
        return target;
    }

    @Override
    public boolean isDirectory() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
//        System.out.println("isLink in link.java");
        return true;
    }

    @Override
    public void accept(FSVisitor v) {
//        System.out.println("accept from link");
        v.visit(this);
    }
}