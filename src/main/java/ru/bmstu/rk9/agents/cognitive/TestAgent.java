package ru.bmstu.rk9.agents.cognitive;

public class TestAgent {

    public static void main(String[] args) {
        CognitiveAgent cognitiveAgent = new SimpleCognitiveAgent();

        String ask1 = "Добрый день! Не подскажите? Есть ли у Вас в продаже исторические романы 19 века?";
        String ask2 = "Добрый день! Не подскажите? Есть ли у Вас исторические романы 19 века?";
        String ask3 = "Добрый день! Не подскажите? Бывают ли у Вас исторические романы 19 века?";
        String ask4 = "Добрый день! Не подскажите? Продаются ли у Вас исторические романы?";

        System.out.println(cognitiveAgent.ask(ask1));
        System.out.println(cognitiveAgent.ask(ask2));
        System.out.println(cognitiveAgent.ask(ask3));
        System.out.println(cognitiveAgent.ask(ask4));
    }
}
