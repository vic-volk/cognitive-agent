package ru.bmstu.rk9.agents;

import ru.bmstu.rk9.agents.bookmaster.BookmasterAgent;
import ru.bmstu.rk9.agents.bookmaster.agent.SimpleBookmasterAgent;
import ru.bmstu.rk9.agents.cognitive.CognitiveAgent;
import ru.bmstu.rk9.agents.cognitive.agent.SimpleCognitiveAgent;

public class TestAgent {

    public static void main(String[] args) throws InterruptedException {
        BookmasterAgent bookmasterAgent = new SimpleBookmasterAgent();
        MessageQueue<String> testQueue = new SimpleMessageQueue<>();
        CognitiveAgent cognitiveAgent1 = new SimpleCognitiveAgent(bookmasterAgent, testQueue);
        CognitiveAgent cognitiveAgent2 = new SimpleCognitiveAgent(bookmasterAgent, testQueue);

        String ask1 = "Добрый день! Не подскажите? Есть ли у Вас в продаже исторические романы 19 века?";
        String ask2 = "Добрый день! Не подскажите? Есть ли у Вас исторические романы 19 века?";
        String ask3 = "Добрый день! Не подскажите? Бывают ли у Вас исторические романы 19 века?";
        String ask4 = "Добрый день! Не подскажите? Продаются ли у Вас исторические романы?";

//        System.out.println(cognitiveAgent.ask(ask1));
//        System.out.println(cognitiveAgent.ask(ask2));
//        System.out.println(cognitiveAgent.ask(ask3));
//        System.out.println(cognitiveAgent.ask(ask4));

        testQueue.push("Test 123");
        testQueue.push("Test 321");
        testQueue.push("Test 123456");

        cognitiveAgent1.startAgent();
        cognitiveAgent2.startAgent();
        Thread.sleep(14 * 1000);

        for (int i = 0; i < 50; i++) {
            testQueue.push("Test: " + i);
        }

        Thread.sleep(70 * 1000);
        cognitiveAgent1.stopAgent();
        cognitiveAgent2.stopAgent();
    }
}
