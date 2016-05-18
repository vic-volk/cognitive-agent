package ru.bmstu.rk9.agents.cognitive;

import java.util.List;

public interface SentenceDivider {

    List<String> detectSentences(String text);
}
