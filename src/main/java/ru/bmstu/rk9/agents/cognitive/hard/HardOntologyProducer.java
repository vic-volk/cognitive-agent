package ru.bmstu.rk9.agents.cognitive.hard;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import ru.bmstu.rk9.agents.cognitive.OntologyProducer;
import uk.ac.manchester.cs.owl.owlapi.OWLObjectPropertyImpl;

import java.util.List;

public class HardOntologyProducer implements OntologyProducer {

    private final String defaultPrefix = "#bookOntology";

    @Override
    public OWLOntology create(List<String> sentences) {
        List<String> preparedSentences = prepare(sentences);
        OWLDataFactory dataFactory = OWLManager.getOWLDataFactory();
        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();

        IRI iri = IRI.create(defaultPrefix);
        try {
            OWLOntology o = ontologyManager.createOntology(iri);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
        OWLClass book = dataFactory.getOWLClass(IRI.create(defaultPrefix, "#book"));
        OWLClass metaInformation = dataFactory.getOWLClass(IRI.create(defaultPrefix, "#meta-information"));

        OWLObjectProperty property = new OWLObjectPropertyImpl(IRI.create(defaultPrefix, "#prop"));
        OWLIndividual concreteBook = dataFactory.getOWLNamedIndividual(IRI.create(defaultPrefix, "#prop"));
        //TODO: process book names
        //TODO: process dates
        return null;
    }

    private List<String> prepare(List<String> sentences) {
        return sentences;
    }
}
