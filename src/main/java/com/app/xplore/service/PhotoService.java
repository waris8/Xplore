package com.app.xplore.service;


import com.app.xplore.models.Photo;
import com.app.xplore.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Response;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final S3Client s3Client;
    private final PhotoRepository photoRepository;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    public String uploadPhoto(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Upload file to S3
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        s3Client.putObject(putObjectRequest, software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));

        // Construct S3 URL
        String fileUrl = "https://" + bucketName + ".s3.amazonaws.com/" + fileName;

        // Save photo details to the database
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setFileUrl(fileUrl);
        photoRepository.save(photo);

        return fileUrl;
    }
}
