package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;

public interface ResponseProducer {

    Response combineResponse(OWLOntology bookResponseOntology);
}
