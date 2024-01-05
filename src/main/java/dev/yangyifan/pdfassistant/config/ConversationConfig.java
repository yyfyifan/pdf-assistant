package dev.yangyifan.pdfassistant.config;

import dev.langchain4j.chain.ConversationalRetrievalChain;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.store.embedding.cassandra.AstraDbEmbeddingStore;
import dev.yangyifan.pdfassistant.properties.TokenProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversationConfig {
    @Bean
    public ConversationalRetrievalChain conversationalRetrievalChain(
            EmbeddingModel embeddingModel,
            AstraDbEmbeddingStore astraDbEmbeddingStore,
            TokenProperties tokenProperties
    ) {
        return ConversationalRetrievalChain.builder()
                .chatLanguageModel(OpenAiChatModel.withApiKey(tokenProperties.openAiToken()))
                .retriever(EmbeddingStoreRetriever.from(astraDbEmbeddingStore, embeddingModel))
                .build();
    }
}
