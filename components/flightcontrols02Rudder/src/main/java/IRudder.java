package main.java;

public interface IRudder {

    String version();

    int neutral();

    int fullRight();

    int fullLeft();

    int right(int degree);

    int left(int degree);
}
