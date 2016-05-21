package ru.bmstu.rk9.agents.bookmaster.agent;

import ru.bmstu.rk9.agents.ACLMessage;
import ru.bmstu.rk9.agents.FIPAMessage;
import ru.bmstu.rk9.agents.bookmaster.BookmasterAgent;

public class SimpleBookmasterAgent implements BookmasterAgent {

    @Override
    public ACLMessage process(ACLMessage aclMessage) {
        return new FIPAMessage();
    }
}
