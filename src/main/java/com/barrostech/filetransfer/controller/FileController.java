package com.barrostech.filetransfer.controller;

import com.amazonaws.HttpMethod;
import com.barrostech.filetransfer.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadAWS")
    public ResponseEntity<String> fileUploadAWS(@RequestParam String extension){
        return ResponseEntity.ok(fileService.generateUrl(
                UUID.randomUUID()+"."+extension, HttpMethod.PUT));

    }

    @GetMapping("/downloadAWS")
    public ResponseEntity<String> fileDownloadAWS(@RequestParam String filename){
        return ResponseEntity.ok(fileService.generateUrl(filename, HttpMethod.GET));
    }
}
