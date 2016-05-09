package ru.bmstu.rk9.agents.cognitive;

import java.util.StringTokenizer;

public class SimpleCognitiveAgent implements CognitiveAgent {

    StringTokenizer tokenizer;

    public String ask(String text) {
        SentenceDivider sentenceDivider = new SentenceDividerImpl();
        String[] sentences = sentenceDivider.detectSentences(text);
        tokenizer = new StringTokenizer(text);
        tokenizer.countTokens();
        return null;
    }
}
