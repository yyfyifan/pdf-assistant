package dev.yangyifan.pdfassistant.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("access-token")
public record TokenProperties(String openAiToken, String astraDbToken) {
}
