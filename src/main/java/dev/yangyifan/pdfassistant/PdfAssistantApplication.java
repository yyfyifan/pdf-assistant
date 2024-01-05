package dev.yangyifan.pdfassistant;

import dev.yangyifan.pdfassistant.properties.DatabaseProperties;
import dev.yangyifan.pdfassistant.properties.EmbeddingProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({EmbeddingProperties.class, DatabaseProperties.class})
public class PdfAssistantApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PdfAssistantApplication.class, args);
        EmbeddingProperties embeddingProperties = applicationContext.getBean(EmbeddingProperties.class);

        DatabaseProperties databaseProperties = applicationContext.getBean(DatabaseProperties.class);
        System.out.println(databaseProperties.accessToken());
    }

}
