package ru.bmstu.rk9.agents.cognitive;

import java.util.List;
import java.util.Map;

public interface SyntaxAnalyzer {

    /**
     * Analyze
     * @param text
     * @return
     */
    String analyzeType(String text);

    Map<String, String> analyzeTypes(List<String> sentences);

}
