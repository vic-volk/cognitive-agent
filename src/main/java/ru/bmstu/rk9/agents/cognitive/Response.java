package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;

public class Response {

    OWLOntology ontology;
    String responseAnswer;

    public OWLOntology getOntology() {
        return ontology;
    }

    public void setOntology(OWLOntology ontology) {
        this.ontology = ontology;
    }

    public String getResponseAnswer() {
        return responseAnswer;
    }

    public void setResponseAnswer(String responseAnswer) {
        this.responseAnswer = responseAnswer;
    }
}
