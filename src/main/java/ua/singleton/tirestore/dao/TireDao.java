package ua.singleton.tirestore.dao;

import ua.singleton.tirestore.model.Tire;

import java.util.List;

public interface TireDao {
    void saveTire(Tire tire);
    List<Tire> loadAllTires();
    Tire loadTireById(int id);
    void deleteTire(int id);
}
