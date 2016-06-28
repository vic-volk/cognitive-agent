package ru.bmstu.rk9.agents;

import java.util.ArrayList;
import java.util.List;

public class SimpleMessageQueue<T> implements MessageQueue<T> {

    private List<T> queue;
    private int index;

    public SimpleMessageQueue() {
        queue = new ArrayList<>();
        index = 0;
    }

    @Override
    public T pop() {
        return queue.get(index-- - 1);
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void push(Object text) {
        queue.add((T) text);
        index++;
    }
}
