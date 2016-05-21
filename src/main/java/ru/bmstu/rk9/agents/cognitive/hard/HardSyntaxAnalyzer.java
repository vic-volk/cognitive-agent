package ru.bmstu.rk9.agents.cognitive.hard;

import ru.bmstu.rk9.agents.cognitive.SyntaxAnalyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TODO: replace with ontology analyzer
public class HardSyntaxAnalyzer implements SyntaxAnalyzer {

    private final String QUESTION = "question";
    private final String NARRATIVE = "narrative";
    private final String EXCLAMATION = "exclamation";


    /**
     * Ищет вопросительные конструкции в предложении
     *  есть ли ..., а у... есть
     * Вопросительные местоимения
     *  где, когда,
     * вопросительные частицы
     *  ли
     * вопросительный знак
     *  ?
     *
     * @param sentences - предложения
     * @return соответствие
     */
    public Map<String, String> analyzeTypes(List<String> sentences) {
        return sentences.stream()
                .collect(Collectors.toMap(s -> s, this::determineType));
    }

    /**
     * types - question, narrative, exclamation
     * @param sentence - предложение
     * @return - тип предложения
     */
    private String determineType(String sentence) {
        if (sentence.contains("?")) {
            return QUESTION;
        }
        if (sentence.matches(".*есть.*ли.*")) {
            return QUESTION;
        }
        if (sentence.matches(".*где.*")) {
            return QUESTION;
        }
        if (sentence.matches(".*а.*у.*есть.*")) {
            return QUESTION;
        }
        if (sentence.matches(".*когда.*")) {
            return QUESTION;
        }
        if (sentence.contains(" ли ")) {
            return QUESTION;
        }
        return NARRATIVE;
    }
}
