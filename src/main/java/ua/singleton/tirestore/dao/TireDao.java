package ua.singleton.tirestore.dao;

import ua.singleton.tirestore.model.Tire;
import java.util.List;

public interface TireDao {
    int saveTire(Tire tire);
    void updateTire(Tire tire);
    List<Tire> loadAllTires();
    Tire loadTireById(int id);
    void deleteTire(Tire tire);
}
