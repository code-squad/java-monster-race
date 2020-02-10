package com.hsik0225;

public interface Movable {
    public String name();
    public String type();
    public String moveLength();
    public void move(int ATTEMPT_COUNT);
}
