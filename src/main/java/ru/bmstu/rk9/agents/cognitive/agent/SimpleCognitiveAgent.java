package ru.bmstu.rk9.agents.cognitive.agent;

import ru.bmstu.rk9.agents.ACLMessage;
import ru.bmstu.rk9.agents.MessageQueue;
import ru.bmstu.rk9.agents.bookmaster.BookmasterAgent;
import ru.bmstu.rk9.agents.cognitive.*;
import ru.bmstu.rk9.agents.cognitive.hard.*;

public class SimpleCognitiveAgent extends AbstractCognitiveAgent {

    private MessageQueue<String> messageQueue;
    private volatile boolean agentShouldStop = false;
    private Thread runner;

    public SimpleCognitiveAgent(BookmasterAgent bookmasterAgent, MessageQueue queue) {
        this.bookmasterAgent = bookmasterAgent;
        this.messageQueue = queue;
        initServices();
    }

    private void initServices() {
        sentenceDivider = new HardSentenceDivider();
        syntaxAnalyzer = new HardSyntaxAnalyzer();
        sentenceFilter = new HardSentenceFilter();
        semanticFilter = sentences -> sentences;
        ontologyProducer = new HardOntologyProducer();
        responseProducer = new HardResponseProducer();
        fipaMessageWrapper = new SimpleFIPAMessageWrapper();
    }

    @Override
    public ACLMessage process(ACLMessage aclMessage) {
        return null;
    }

    @Override
    public void run() {
        while (!agentShouldStop) {
            try {
                //посмотреть очередь сообщений
                if (messageQueue.size() != 0) {
                    System.out.println("Agent: " + this.hashCode());
                    System.out.println("message queue is not empty");
                    System.out.println("Size: " + messageQueue.size());
                    String message = messageQueue.pop();
                    System.out.println("Message: " + message);
                    String answer = ask(message);
                    System.out.println("Answer: " + answer);
                } else {
                    System.out.println("message queue is empty");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //выполнить запрос, если есть сообщение
            //если нет сообщений, то подождать
        }
    }

    public synchronized void startAgent() {
        runner = new Thread(this);
        runner.start();
    }

    public synchronized void stopAgent() {
        if (!agentShouldStop) {
            agentShouldStop = true;
            System.out.println("Stopping");
            runner.interrupt();
        }
    }
}
