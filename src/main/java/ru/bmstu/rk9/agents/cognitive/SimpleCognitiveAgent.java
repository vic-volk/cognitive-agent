package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;
import ru.bmstu.rk9.agents.AgentCommunicationBus;

import java.util.List;
import java.util.Map;

public class SimpleCognitiveAgent implements CognitiveAgent {

    //// Services ////
    SentenceDivider sentenceDivider;
    SyntaxAnalyzer syntaxAnalyzer;
    SentenceFilter sentenceFilter;
    SemanticFilter semanticFilter;
    OntologyProducer ontologyProducer;
    AgentCommunicationBus agentCommunicationBus;
    ResponseProducer responseProducer;

    /**
     * Определить предложения по тексту
     * Определить типы предложений по предложениям
     * Отфильтровать вопросительные предложения
     * Определить те вопросительные предложения, в которых спрашивают книги
     * Сформировать онтологии по запросам по книгам
     *
     * временные требования: уложиться в одну секунду
     *
     * @param text - входной текст
     * @return
     */
    public String ask(String text) {
        List<String> sentences = sentenceDivider.detectSentences(text);
        Map<String, String> typeMap = syntaxAnalyzer.analyzeTypes(sentences);
        List<String> questionSentences = sentenceFilter.filterQuestionSentences(typeMap);
        List<String> bookSentences = semanticFilter.determBookSentences(questionSentences);
        OWLOntology bookOntology = ontologyProducer.create(bookSentences);
        OWLOntology responseOntology = agentCommunicationBus.request(1, bookOntology);
        Response response = responseProducer.combineReponse(responseOntology);
        return response.getResponseAnswer();
    }
}
