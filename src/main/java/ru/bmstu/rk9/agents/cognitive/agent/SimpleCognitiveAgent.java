package ru.bmstu.rk9.agents.cognitive.agent;

import ru.bmstu.rk9.agents.ACLMessage;
import ru.bmstu.rk9.agents.bookmaster.BookmasterAgent;
import ru.bmstu.rk9.agents.cognitive.*;
import ru.bmstu.rk9.agents.cognitive.hard.*;

public class SimpleCognitiveAgent extends AbstractCognitiveAgent {

    public SimpleCognitiveAgent(BookmasterAgent bookmasterAgent) {
        this.bookmasterAgent = bookmasterAgent;
    }

    @Override
    public void initServices() {
        sentenceDivider = new HardSentenceDivider();
        syntaxAnalyzer = new HardSyntaxAnalyzer();
        sentenceFilter = new HardSentenceFilter();
        semanticFilter = sentences -> sentences;
        ontologyProducer = new HardOntologyProducer();
        responseProducer = new HardResponseProducer();
    }

    @Override
    public ACLMessage process(ACLMessage aclMessage) {
        return null;
    }
}
