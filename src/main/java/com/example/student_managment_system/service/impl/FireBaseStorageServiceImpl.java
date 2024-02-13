package com.example.student_managment_system.service.impl;

import com.example.student_managment_system.service.FireBaseStorageService;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FireBaseStorageServiceImpl implements FireBaseStorageService {

    private static final String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/spring-boot-firebase-test.appspot.com/o/%s?alt=media";


    @Override
    public String uploadImage(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.
            String filePath = "student-images/" + fileName;                               // Prepend the folder path here
            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String url = this.uploadFile(file, filePath);                                   // to get uploaded file link
            file.delete();
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }

    private String uploadFile(File file, String filePath) throws IOException {
        BlobId blobId = BlobId.of("spring-boot-firebase-test.appspot.com", filePath); // Replace with your bucket name
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        InputStream inputStream = FireBaseStorageServiceImpl.class.getClassLoader()
                .getResourceAsStream("spring-boot-firebase-test-firebase-adminsdk-dz5v8-bd762eb14a.json"); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format(DOWNLOAD_URL, URLEncoder.encode(filePath, StandardCharsets.UTF_8));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
