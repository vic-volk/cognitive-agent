package ru.bmstu.rk9.agents.cognitive;

import java.util.List;
import java.util.Map;

public interface SentenceFilter {

    List<String> filterQuestionSentences(Map<String, String> typeMap);
}
