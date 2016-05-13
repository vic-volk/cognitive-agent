package ru.bmstu.rk9.agents.cognitive.agnet;

import java.util.List;

public interface SentenceDivider {

    //TODO: detect by ontology
    List<String> detectSentences(String text);
}
