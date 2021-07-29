package tech.btzstudio.teamline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import tech.btzstudio.teamline.controller.PictureController;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@Service
public class PictureService {

    private final StorageService storageService;

    public PictureService (StorageService storageService) {
        this.storageService = storageService;
    }

    public Resource file (String fileName) {
        return storageService.load(fileName);
    }

    public List<String> upload (List<MultipartFile> files) {
        final List<String> urls = new LinkedList<>();

        files.forEach(file -> {
            final String fileName = storageService.save(file);
            urls.add(
                    MvcUriComponentsBuilder
                            .fromMethodCall(on(PictureController.class).picture(fileName))
                            .build()
                            .toUriString()
            );
        });

        return urls;
    }
}
