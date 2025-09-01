package top.guxx.rag.http;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.guxx.rag.api.response.Response;
import top.guxx.rag.api.service.IRAGService;

import java.util.List;

@Slf4j
@RestController()
@CrossOrigin("*")
@RequestMapping("/api/v1/rag/")
public class RAGController implements IRAGService {

    @Resource
    private TokenTextSplitter tokenTextSplitter;
    @Resource
    private PgVectorStore pgVectorStore;
    @Resource
    private RedissonClient redissonClient;

    @RequestMapping(value = "query_rag_tag_list", method = RequestMethod.GET)
    @Override
    public List<String> getRagTags() {
        RList<String> ragTags = redissonClient.getList("ragTags");
        if (CollectionUtils.isEmpty(ragTags)){
            return List.of();
        }
        return ragTags;
    }


    @RequestMapping(value = "file/upload", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    @Override
    public Response<String> uploadRag(@RequestParam String ragTag, @RequestParam("file") List<MultipartFile> multipartFiles) {
        for (MultipartFile file : multipartFiles) {
            TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(file.getResource());
            List<Document> documents = tikaDocumentReader.get();
            List<Document> apply = tokenTextSplitter.apply(documents);
            documents.forEach(document -> document.getMetadata().put("knowledge", ragTag));
            apply.forEach(document -> {document.getMetadata().put("knowledge", ragTag);});
            pgVectorStore.accept(apply);
        }
        RList<String> ragTags = redissonClient.getList("ragTags");
        if (!ragTags.contains(ragTag)){
            ragTags.add(ragTag);
        }
        log.info("上传知识库完成 {}", ragTag);
        return Response.<String>builder().code("0000").info("调用成功").build();
    }
}
