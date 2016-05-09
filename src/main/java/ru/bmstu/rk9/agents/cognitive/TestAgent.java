package ru.bmstu.rk9.agents.cognitive;

public class TestAgent {

    public static void main(String[] args) {
        CognitiveAgent cognitiveAgent = new SimpleCognitiveAgent();
        cognitiveAgent.ask("Добрый день! Не подскажите? Есть ли у Вас в продаже исторические романы 19 века?");
        cognitiveAgent.ask("Добрый день! Не подскажите? Есть ли у Вас исторические романы 19 века?");
        cognitiveAgent.ask("Добрый день! Не подскажите? Бывают ли у Вас исторические романы 19 века?");
        cognitiveAgent.ask("Добрый день! Не подскажите? Продаются ли у Вас исторические романы?");
    }
}
