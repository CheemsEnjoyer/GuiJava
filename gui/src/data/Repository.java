package data;
import java.util.List;
public interface Repository {
    int getCount();
    Doctor getDoctor(int index);
    Doctor findById(int id);
    List<Doctor> findAll();
    void save(Doctor doctor);
    void update(Doctor doctor);
    void delete(Doctor doctor);
    void loadDataFromFile(String filePath);
}
