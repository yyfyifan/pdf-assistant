package dev.yangyifan.pdfassistant.web.chat;


import dev.langchain4j.chain.ConversationalRetrievalChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final ConversationalRetrievalChain conversationalRetrievalChain;

    public ChatController(ConversationalRetrievalChain conversationalRetrievalChain) {
        this.conversationalRetrievalChain = conversationalRetrievalChain;
    }

    @PostMapping
    public String chat(@RequestBody ChatDTO chatDTO) {
        logger.info("Received {}", chatDTO);
        return conversationalRetrievalChain.execute(chatDTO.question());
    }

    // TODO: Add an endpoint to accept uploading PDF files.
}
