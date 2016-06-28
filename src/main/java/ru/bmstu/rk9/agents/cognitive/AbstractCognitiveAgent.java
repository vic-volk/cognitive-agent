package ru.bmstu.rk9.agents.cognitive;

import org.semanticweb.owlapi.model.OWLOntology;
import ru.bmstu.rk9.agents.ACLMessage;
import ru.bmstu.rk9.agents.FIPAMessage;
import ru.bmstu.rk9.agents.bookmaster.BookmasterAgent;

import java.util.List;
import java.util.Map;

public abstract class AbstractCognitiveAgent implements CognitiveAgent {

    protected BookmasterAgent bookmasterAgent;

    //// Services ////
    protected SentenceDivider sentenceDivider;
    protected SyntaxAnalyzer syntaxAnalyzer;
    protected SentenceFilter sentenceFilter;
    protected SemanticFilter semanticFilter;
    protected OntologyProducer ontologyProducer;
    protected FIPAMessageWrapper fipaMessageWrapper;
    protected ResponseProducer responseProducer;

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
     * @return ответ агента
     */
    public String ask(String text) {
        //  Определить предложения по тексту
        List<String> sentences = sentenceDivider.detectSentences(text);
        //  Определить типы предложений по предложениям
        Map<String, String> typeMap = syntaxAnalyzer.analyzeTypes(sentences);
        //  Отфильтровать вопросительные предложения
        List<String> questionSentences = sentenceFilter.filterQuestionSentences(typeMap);
        //  Определить те вопросительные предложения, в которых спрашивают книги
        List<String> bookSentences = semanticFilter.determineBookSentences(questionSentences);
        //  Сформировать онтологии по запросам по книгам
        OWLOntology bookOntology = ontologyProducer.create(bookSentences);
        //  Обернуть онтологию в сообщение протокола FIPA
        FIPAMessage fipaMessage = fipaMessageWrapper.wrapMessage(1, bookOntology);
        //  Получить ответ от агента-эксперта по книгам
        ACLMessage aclMessage = bookmasterAgent.process(fipaMessage);
        Response response = responseProducer.combineResponse(aclMessage);
        return response.getResponseAnswer();
    }
}
