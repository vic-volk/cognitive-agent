package ru.bmstu.rk9.agents.cognitive;

import java.util.List;
import java.util.Map;

public interface SyntaxAnalyzer {

    /**
     * Анализирует типы предложений:
     * повествовательные, вопросительные, восклицательные
     * @param sentences - предложения
     * @return - соответствие предложений их типам
     */
    Map<String, String> analyzeTypes(List<String> sentences);

}
