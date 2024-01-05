package dev.yangyifan.pdfassistant.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("embedding.model")
public record EmbeddingProperties(int dimension) {

}
