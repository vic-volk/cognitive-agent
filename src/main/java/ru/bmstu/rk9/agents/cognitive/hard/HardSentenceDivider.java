package ru.bmstu.rk9.agents.cognitive.hard;

import com.google.common.collect.Lists;
import ru.bmstu.rk9.agents.cognitive.SentenceDivider;

import java.util.List;

public class HardSentenceDivider implements SentenceDivider {

    public List<String> detectSentences(String text) {
        return Lists.newArrayList(text.split("\\!|\\?|\\."));
    }
}
