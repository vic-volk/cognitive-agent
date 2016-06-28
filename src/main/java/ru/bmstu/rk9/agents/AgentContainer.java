package ru.bmstu.rk9.agents;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AgentContainer {

    ExecutorService executorService;

    public AgentContainer() {
        executorService = Executors.newCachedThreadPool();
    }

    public void runAgent(Agent agent) {
        executorService.submit(agent);
    }
}
