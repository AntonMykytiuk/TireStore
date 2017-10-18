package ua.singleton.tirestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.singleton.tirestore.dao.TireDao;
import ua.singleton.tirestore.model.Tire;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TireServiceImp implements TireService {

    private TireDao tireDao;
    private ImageUploadService imageUploadService;

    @Autowired
    public TireServiceImp(TireDao tireDao, ImageUploadService imageUploadService) {
        this.tireDao = tireDao;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public void saveTire(Tire tire) {
        MultipartFile image = tire.getFile();
        if(!image.isEmpty()) {
            tire.setImageExtension(imageUploadService.getImageExtension(image));
            int id = tireDao.saveTire(tire);
            imageUploadService.saveImage(id, image);
        } else {
            tireDao.saveTire(tire);
        }
    }

    @Override
    public void updateTire(Tire tire) {
        MultipartFile image = tire.getFile();
        if(!image.isEmpty()) {
            tire.setImageExtension(imageUploadService.getImageExtension(image));
            imageUploadService.saveImage(tire.getId(), image);
        }
        tireDao.updateTire(tire);
    }

    @Override
    public List<Tire> loadAllTires() {
        return tireDao.loadAllTires();
    }

    @Override
    public Tire loadTireById(int id) {
        return tireDao.loadTireById(id);
    }

    @Override
    public void deleteTire(int id) {
        Tire tire = tireDao.loadTireById(id);
        imageUploadService.deleteImage(id, tire.getImageExtension());
        tireDao.deleteTire(tire);
    }
}
