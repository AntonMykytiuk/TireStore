package ua.singleton.tirestore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class ImageUploadService {

    @Value("${images.root.path}")
    private String imagesRootPath;

    String getImageExtension(MultipartFile image) {
        return image.getOriginalFilename().split("\\.")[1];
    }

    void saveImage(int id, MultipartFile image){

        try {
            byte[] bytes = image.getBytes();

            System.out.println(imagesRootPath);
            File serverImage = new File(imagesRootPath + "tire_image_" + id
                    + "." + getImageExtension(image));
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverImage, false));
            stream.write(bytes);
            stream.close();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    void deleteImage(int id, String imageExtension) {
        File serverImage = new File(imagesRootPath + "tire_image_" + id
                + "." + imageExtension);
        boolean boo = serverImage.delete();

    }
}
