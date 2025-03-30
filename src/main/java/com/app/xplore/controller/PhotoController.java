package com.app.xplore.controller;


import com.app.xplore.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotoController {

    @Autowired
    private final PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = photoService.uploadPhoto(file);
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<byte[]> getPhotoById(@RequestParam String id) throws IOException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(photoService.getPhoto(id));
    }
}
