package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;

import java.util.List;

public interface OntologyProducer {

    OWLOntology create(List<String> sentences);
}
