package ua.singleton.tirestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.singleton.tirestore.dao.TireDao;
import ua.singleton.tirestore.model.Tire;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TireServiceImp implements TireService {

    private TireDao tireDao;

    @Autowired
    public TireServiceImp(TireDao tireDao) {
        this.tireDao = tireDao;
    }

    @Override
    public void saveTire(Tire tire) {
        tireDao.saveTire(tire);
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
        tireDao.deleteTire(id);
    }
}
