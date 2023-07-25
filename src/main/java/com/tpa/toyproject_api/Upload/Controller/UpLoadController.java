package com.tpa.toyproject_api.Upload.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "http://localhost:3000")
public class UpLoadController {

    @Value("${upload.directory}")
    private String uploadDir;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("/save")
    public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("파일이 없습니다.");
        }

        try {
            // 파일 저장 경로 설정
            Resource resource = resourceLoader.getResource(uploadDir);
            File uploadPath = resource.getFile();
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            // 파일 저장
            String originalFileName = file.getOriginalFilename();
            File destination = new File(uploadPath, originalFileName);
            FileCopyUtils.copy(file.getBytes(), destination);

            // 파일 경로 반환
            String filePath = destination.getAbsolutePath();

            return ResponseEntity.ok(filePath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 중 오류가 발생했습니다.");
        }
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendImage(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("파일이 없습니다.");
        }

        try {
            byte[] imageBytes = file.getBytes();
            String base64String = Base64.getEncoder().encodeToString(imageBytes);

            String json = gsonToJson(base64String);

            System.out.println("\n" + json);

            RestTemplate restTemplate = new RestTemplate();
            String url = "https://port-0-aiserver-20zynm2mljxybsqy.sel4.cloudtype.app/carNum";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

            return response;
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 중 오류가 발생했습니다.");
        }
    }

    public String gsonToJson(String base64){
        JsonObject jo = new JsonObject();

        jo.addProperty("img", base64);

        return jo.toString();
    }

}
