package ru.bmstu.rk9.agents.cognitive;

import java.util.List;

public interface SentenceDivider {

    /**
     * Метод делит текст на предложения
     * @param text
     * @return
     */
    List<String> detectSentences(String text);
}
