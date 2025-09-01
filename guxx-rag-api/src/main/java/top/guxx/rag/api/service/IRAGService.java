package top.guxx.rag.api.service;

import org.springframework.web.multipart.MultipartFile;
import top.guxx.rag.api.response.Response;

import java.util.List;

public interface IRAGService {
    List<String> getRagTags();

    Response<String> uploadRag(String ragTag, List<MultipartFile> multipartFiles);
}
