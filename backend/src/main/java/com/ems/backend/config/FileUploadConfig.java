package com.ems.backend.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class FileUploadConfig {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostConstruct
    public void init() {

        File folder = new File(uploadDir);

        if (!folder.exists()) {

            folder.mkdirs();

            System.out.println("Uploads folder created successfully.");
        } else {

            System.out.println("Uploads folder already exists.");
        }
    }
}