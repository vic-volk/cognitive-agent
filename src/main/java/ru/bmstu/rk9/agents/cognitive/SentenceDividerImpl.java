package ru.bmstu.rk9.agents.cognitive;

public class SentenceDividerImpl implements SentenceDivider {

    //TODO: разделители подгрузить из онтологии
    public String[] detectSentences(String text) {
        return text.split("[\\?\\!]");
    }
}
