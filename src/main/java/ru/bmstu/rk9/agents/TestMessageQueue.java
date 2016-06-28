package ru.bmstu.rk9.agents;

public class TestMessageQueue {

    public static void main(String[] args) {
        MessageQueue<String> queue = new SimpleMessageQueue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
