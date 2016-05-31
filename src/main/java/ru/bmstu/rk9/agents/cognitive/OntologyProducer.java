package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.util.List;

public interface OntologyProducer {

    OWLOntology create(List<String> sentences) throws OWLOntologyCreationException;
}
