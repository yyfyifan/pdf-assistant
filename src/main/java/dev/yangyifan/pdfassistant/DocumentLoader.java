package dev.yangyifan.pdfassistant;

import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;

@Component
public class DocumentLoader {
    private final EmbeddingStoreIngestor ingestor;
    private final ResourceLoader resourceLoader;

    public DocumentLoader(EmbeddingStoreIngestor ingestor,
                                   ResourceLoader resourceLoader) {
        this.ingestor = ingestor;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void init() {
        ingestDocuments();
    }

    // TODO: Dynamically load all pdfs either from the resources directory, or with API calls
    private void ingestDocuments() {
        ingestor.ingest(loadDocument(
                getPathForResource("cassandra.pdf"),
                new ApachePdfBoxDocumentParser()));
    }

    private Path getPathForResource(String fileName)  {
        try {
            return Path.of(resourceLoader.getResource("classpath:" + fileName).getURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
