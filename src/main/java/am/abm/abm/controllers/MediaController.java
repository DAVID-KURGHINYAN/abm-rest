package am.abm.abm.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("media/")
public class MediaController {

    @GetMapping("image/{fileName}")
    ResponseEntity<byte[]> getMedia(@PathVariable String fileName){
        File file = new File("src/main/resources/media/" + fileName);
        try {
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" +file.getName())
                    .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
                    .body(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
