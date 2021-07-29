package tech.btzstudio.teamline.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    String save (MultipartFile file);

    Stream<Path> loadAll();

    Resource load(String filename);

    void deleteAll();
}
