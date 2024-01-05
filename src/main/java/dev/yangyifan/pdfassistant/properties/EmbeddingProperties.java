package dev.yangyifan.pdfassistant.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("embedding")
public record EmbeddingProperties(int modelDimension,
                                  int maxSegmentChars,
                                  int maxOverlayTokens) {

}
