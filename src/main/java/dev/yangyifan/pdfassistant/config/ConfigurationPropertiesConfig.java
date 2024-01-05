package dev.yangyifan.pdfassistant.config;


import dev.yangyifan.pdfassistant.properties.DatabaseProperties;
import dev.yangyifan.pdfassistant.properties.EmbeddingProperties;
import dev.yangyifan.pdfassistant.properties.TokenProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

// Registers the properties classes with 'EnableConfigurationProperties' annotation.
@Component
@EnableConfigurationProperties({EmbeddingProperties.class, DatabaseProperties.class, TokenProperties.class})
public class ConfigurationPropertiesConfig {
}
