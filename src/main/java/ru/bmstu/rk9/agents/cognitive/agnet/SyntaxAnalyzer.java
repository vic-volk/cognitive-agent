package ru.bmstu.rk9.agents.cognitive.agnet;

public interface SyntaxAnalyzer {

    /**
     * Анализатор предложенией, получает предложение, как текст. Проводит грамматический анализ взаимосвязей
     * между словами, определяет смымсл предложения, работает на основе онтологии.
     *
     *
     * @param text - предложение
     * @return - возвращает тип предложения
     */
    String analyzeType(String text);

}
