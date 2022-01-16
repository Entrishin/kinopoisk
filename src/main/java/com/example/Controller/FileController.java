package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileController {

    @Autowired
    private HttpServletRequest request;

    private final String UPLOAD_DIR = "UploadedImages/";


    public String uploadFile(MultipartFile file,String generatedFileName) {

        // check if file is empty
        if (file.isEmpty()) {
            return "";
        }

        File directory = new File("UploadedImages");
        if (! directory.exists()){
            directory.mkdir();
            //creating directory if not exists
        }

        // normalize the file path
        String fileName = generatedFileName + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());

        // save the file on the local file system
        try {
            //Path path = Paths.get(UPLOAD_DIR + fileName);
            //Path path = Paths.get(request.getServletContext().getRealPath("/img/") + fileName);
            //Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            File fl = new File(UPLOAD_DIR + fileName);
            try (OutputStream os = new FileOutputStream(fl)) {
                os.write(file.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response

        return fileName;
    }

}
