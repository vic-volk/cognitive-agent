package ru.bmstu.rk9.agents;

public interface Agent extends Runnable {

    ACLMessage process(ACLMessage aclMessage);
}
