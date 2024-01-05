package dev.yangyifan.pdfassistant.config;

import dev.langchain4j.store.embedding.cassandra.AstraDbEmbeddingConfiguration;
import dev.langchain4j.store.embedding.cassandra.AstraDbEmbeddingStore;
import dev.yangyifan.pdfassistant.properties.DatabaseProperties;
import dev.yangyifan.pdfassistant.properties.EmbeddingProperties;
import dev.yangyifan.pdfassistant.properties.TokenProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    private final DatabaseProperties databaseProperties;
    private final EmbeddingProperties embeddingProperties;
    private final TokenProperties tokenProperties;
    public DatabaseConfig(DatabaseProperties databaseProperties,
                          EmbeddingProperties embeddingProperties,
                          TokenProperties tokenProperties) {
        this.databaseProperties = databaseProperties;
        this.embeddingProperties = embeddingProperties;
        this.tokenProperties = tokenProperties;
    }

    // The connection with the Astra DB.
    @Bean
    public AstraDbEmbeddingStore astraDbEmbeddingStore() {
        return new AstraDbEmbeddingStore(AstraDbEmbeddingConfiguration
                .builder()
                .token(tokenProperties.astraDbToken())
                .databaseId(databaseProperties.databaseId())
                .databaseRegion(databaseProperties.region())
                .keyspace(databaseProperties.keyspace())
                .table(databaseProperties.table())
                .dimension(embeddingProperties.modelDimension())
                .build());
    }
}
