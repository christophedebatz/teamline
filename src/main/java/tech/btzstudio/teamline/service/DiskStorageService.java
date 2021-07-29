package tech.btzstudio.teamline.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class DiskStorageService implements StorageService {

    private final String UPLOAD_DIR = "/uploads";
    private final Path root = Paths.get(UPLOAD_DIR);

    @Override
    public void init () {
        try {
            Files.createDirectory(root);
        } catch (IOException ex) {
            throw new RuntimeException("Could not init the store service.", ex.getCause());
        }
    }

    @Override
    public String save (MultipartFile file) {
        try {
            final String fileName = UUID.randomUUID().toString();
            Files.copy(file.getInputStream(), root.resolve(fileName));
            return fileName;
        } catch (Exception ex) {
            throw new RuntimeException("Could not store the file.", ex.getCause());
        }

    }

    @Override
    public Stream<Path> loadAll () {
        return null;
    }

    @Override
    public Resource load (String filename) {
        try {
            final Path file = root.resolve(filename);
            final Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            }

            throw new RuntimeException("Could not read the file!");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll () {

    }
}
