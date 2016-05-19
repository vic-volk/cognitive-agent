package ru.bmstu.rk9.agents.cognitive;

import java.util.List;

public interface SemanticFilter {


    List<String> determineBookSentences(List<String> sentences);
}
