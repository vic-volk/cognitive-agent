package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;
import ru.bmstu.rk9.agents.FIPAMessage;

public interface FIPAMessageWrapper {

    FIPAMessage wrapMessage(Integer agentId, OWLOntology owlOntology);
}
