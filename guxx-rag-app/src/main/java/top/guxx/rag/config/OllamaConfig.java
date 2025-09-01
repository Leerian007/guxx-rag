package top.guxx.rag.config;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class OllamaConfig {

//    @Bean
//    @Primary
//    public OllamaApi ollamaApi(@Value("${spring.ai.ollama.base-url}") String baseUrl) {
//        return new OllamaApi(baseUrl);
//    }
//
//    @Bean
//    public OpenAiApi openAiApi(@Value("${spring.ai.openai.base-url}") String baseUrl, @Value("${spring.ai.openai.api-key}") String apikey) {
//        return new OpenAiApi(baseUrl, apikey);
//    }



//    @Bean
//    public OllamaChatClient ollamaChatClient(OllamaApi ollamaApi) {
//        return new OllamaChatClient(ollamaApi);
//    }

//    @Bean
//    public TokenTextSplitter tokenTextSplitter() {
//        return new TokenTextSplitter();
//    }

    //    @Bean
//    public SimpleVectorStore vectorStore(@Value("${spring.ai.rag.embed}") String model, OllamaApi ollamaApi, OpenAiApi openAiApi) {
//        if ("nomic-embed-text".equalsIgnoreCase(model)) {
//            OllamaEmbeddingClient embeddingClient = new OllamaEmbeddingClient(ollamaApi);
//            embeddingClient.withDefaultOptions(OllamaOptions.create().withModel("nomic-embed-text"));
//            return new SimpleVectorStore(embeddingClient);
//        } else {
//            OpenAiEmbeddingClient embeddingClient = new OpenAiEmbeddingClient(openAiApi);
//            return new SimpleVectorStore(embeddingClient);
//        }
//    }
//    @Bean("ollamaSimpleVectorStore")
//    public SimpleVectorStore vectorStore(OllamaApi ollamaApi) {
//        OllamaEmbeddingModel embeddingModel = OllamaEmbeddingModel
//                .builder()
//                .ollamaApi(ollamaApi)
//                .defaultOptions(OllamaOptions.builder().model("nomic-embed-text").build())
//                .build();
//        return SimpleVectorStore.builder(embeddingModel).build();
//    }
//
//
//    @Bean("ollamaPgVectorStore")
//    public PgVectorStore pgVectorStore(OllamaApi ollamaApi, JdbcTemplate jdbcTemplate) {
//        OllamaEmbeddingModel embeddingModel = OllamaEmbeddingModel
//                .builder()
//                .ollamaApi(ollamaApi)
//                .defaultOptions(OllamaOptions.builder().model("nomic-embed-text").build())
//                .build();
//        return PgVectorStore.builder(jdbcTemplate, embeddingModel)
//                .vectorTableName("vector_store_ollama_deepseek")
//                .build();
//    }


}
