package ru.bmstu.rk9.agents.cognitive.hard;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import ru.bmstu.rk9.agents.cognitive.OntologyProducer;

import java.util.List;

public class HardOntologyProducer implements OntologyProducer {

    private final String defaultPrefix = "#bookOntology";

    @Override
    public OWLOntology create(List<String> sentences) throws OWLOntologyCreationException {
        List<String> preparedSentences = prepare(sentences);
        OWLDataFactory dataFactory = OWLManager.getOWLDataFactory();
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();

        IRI iri = IRI.create(defaultPrefix);
        OWLOntology o = ontologyManager.createOntology(iri);
        OWLClass book = dataFactory.getOWLClass(IRI.create(defaultPrefix, "#book"));
        OWLClass metaInformation = dataFactory.getOWLClass(IRI.create(defaultPrefix, "#meta-information"));

        OWLObjectProperty
        OWLIndividual concreteBook = dataFactory.getOWLNamedIndividual();
        //TODO: process book names
        //TODO: process dates
        return preparedSentences;
    }

    private List<String> prepare(List<String> sentences) {
        return sentences;
    }
}
