package ru.bmstu.rk9.agents;

import org.semanticweb.owlapi.model.OWLOntology;

public interface AgentCommunicationBus {

    OWLOntology request(Integer agentId, OWLOntology ontology);
}
