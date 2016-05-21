package ru.bmstu.rk9.agents.cognitive;

import ru.bmstu.rk9.agents.ACLMessage;

public interface ResponseProducer {

    Response combineResponse(ACLMessage aclMessage);
}
