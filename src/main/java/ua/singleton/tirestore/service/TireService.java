package ua.singleton.tirestore.service;

import ua.singleton.tirestore.dao.TireDao;
import ua.singleton.tirestore.model.Tire;

import java.util.List;


public interface TireService {
    void saveTire(Tire tire);
    void updateTire(Tire tire);
    List<Tire> loadAllTires();
    Tire loadTireById(int id);
    void deleteTire(int id);
}
