package ru.bmstu.rk9.agents.cognitive;

import ru.bmstu.rk9.agents.Agent;

public interface CognitiveAgent extends Agent {

    /**
     * Парсер обрабатывает человеческий вопрос
     * анализирует предложения
     * преобразует в запросы по книгам (анализирует предложения на предмет смысловых глаголов)
     * формирует ответы
     * выдает ответы
     * @param text
     * @return
     */
    String ask(String text);

    void startAgent();

    void stopAgent();
}
