package ru.bmstu.rk9.agents.cognitive.agnet;

import ru.bmstu.rk9.agents.cognitive.*;
import ru.bmstu.rk9.agents.cognitive.hard.HardSentenceDivider;

public class SimpleCognitiveAgent extends AbstractCognitiveAgent {

    @Override
    public void initServices() {
        sentenceDivider = new HardSentenceDivider();
        syntaxAnalyzer = ;
        sentenceFilter = ;
        semanticFilter = ;
        ontologyProducer = ;
        agentCommunicationBus = ;
        responseProducer = ;
    }
}
