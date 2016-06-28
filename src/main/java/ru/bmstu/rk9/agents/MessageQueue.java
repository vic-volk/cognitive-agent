package ru.bmstu.rk9.agents;

public interface MessageQueue<T> {

    T pop();

    void push(T text);

    int size();
}
