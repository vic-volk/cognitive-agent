package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;
import ru.bmstu.rk9.agents.FIPAMessage;

public class SimpleFIPAMessageWrapper implements FIPAMessageWrapper {


    @Override
    public FIPAMessage wrapMessage(Integer agentId, OWLOntology owlOntology) {
        return new FIPAMessage();
    }
}
