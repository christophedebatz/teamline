package tech.btzstudio.teamline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.btzstudio.teamline.domain.Picture;
import tech.btzstudio.teamline.domain.repository.PictureRepository;
import tech.btzstudio.teamline.service.PictureService;
import tech.btzstudio.teamline.service.UserService;
import tech.btzstudio.teamline.model.exception.NotFoundHttpException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PictureController {

    @Autowired
    private PictureService pictureService;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private UserService userService;

    @GetMapping ("/pictures")
    public List<Picture> listAll() {
        return StreamSupport
                .stream(pictureRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping ("/pictures/{fileName:.+}")
    public ResponseEntity<Resource> picture(@PathVariable String fileName) {
        final Resource file = pictureService.file(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @PostMapping ("/users/{userId}/upload")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<String> upload(
            @PathVariable Long userId,
            @RequestParam(name = "pictures") MultipartFile[] pictures
    ) {
        if (userService.find(userId).isEmpty()) {
            return pictureService.upload(Arrays.asList(pictures));
        }

        throw new NotFoundHttpException("user-not-found");
    }
}
