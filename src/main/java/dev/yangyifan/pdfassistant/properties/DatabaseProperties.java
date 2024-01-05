package dev.yangyifan.pdfassistant.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("astradb")
public record DatabaseProperties(String databaseId, String region, String keyspace, String table, String accessToken) {

}
