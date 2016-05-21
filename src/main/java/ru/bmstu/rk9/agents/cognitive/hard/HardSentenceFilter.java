package ru.bmstu.rk9.agents.cognitive.hard;

import ru.bmstu.rk9.agents.cognitive.SentenceFilter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HardSentenceFilter implements SentenceFilter {

    @Override
    public List<String> filterQuestionSentences(Map<String, String> typeMap) {
        return typeMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals("question"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
