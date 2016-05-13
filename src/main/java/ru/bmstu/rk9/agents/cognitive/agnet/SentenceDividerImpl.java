package ru.bmstu.rk9.agents.cognitive.agnet;

import com.google.common.collect.Lists;
import java.util.List;

public class SentenceDividerImpl implements SentenceDivider {

    //TODO: разделители подгрузить из онтологии
    public List<String> detectSentences(String text) {
        return Lists.newArrayList(text.split("[\\?\\!]"));
    }
}
