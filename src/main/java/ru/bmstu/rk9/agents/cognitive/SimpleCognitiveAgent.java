package ru.bmstu.rk9.agents.cognitive;

import java.util.List;
import java.util.StringTokenizer;

public class SimpleCognitiveAgent implements CognitiveAgent {

    StringTokenizer tokenizer;

    /**
     * Производится анализ вопроса:
     * 1. анализ предложений
     * 2. анализ каждого из предложений
     * 3. грамматический анализ предложения - разбор состава
     *      подлежащее, сказуемое, дополнение, уточнение и тд.
     * 3.5 формирование запросов по предложениям
     * 4. формирование онтологического запроса другому агенту
     * 5. прием онтологического ответа
     * 6. формирование ответа
     * @param text
     * @return
     */
    public String ask(String text) {
        SentenceDivider sentenceDivider = new SentenceDividerImpl();
        List<String> sentences = sentenceDivider.detectSentences(text);

        tokenizer = new StringTokenizer(text);
        tokenizer.countTokens();
        return null;
    }
}
