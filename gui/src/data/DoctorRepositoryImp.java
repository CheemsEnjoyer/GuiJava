package data;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepositoryImp implements Repository {
    private List<Doctor> doctors;
    private Map<Integer, Doctor> doctorMap;

    public DoctorRepositoryImp() {
        doctors = new ArrayList<>();
        doctorMap = new HashMap<>();
        loadDataFromFile("src/listOfDoctors.txt");
    }

    @Override
    public void loadDataFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int id = 1;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String specialization = parts[1].trim();
                    int visitCounts = Integer.parseInt(parts[2].trim());
                    Doctor doctor = new Doctor(id++, name, specialization, visitCounts);
                    doctors.add(doctor);
                    doctorMap.put(doctor.getId(), doctor);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных о докторах из файла.");
        }
    }

    @Override
    public int getCount() {
        int count = 0;
        String filePath = "src/listOfDoctors.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении данных о врачах из файла.");
        }
        return count;
    }

    @Override
    public Doctor getDoctor(int index) {
        return doctors.get(index);
    }

    @Override
    public Doctor findById(int id) {
        String filePath = "src/listOfDoctors.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int doctorId = Integer.parseInt(parts[0].trim());
                    if (doctorId == id) {
                        String name = parts[1].trim();
                        String specialization = parts[2].trim();
                        int visitCount = Integer.parseInt(parts[3].trim());
                        return new Doctor(id, name, specialization, visitCount);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных о докторах из файла.");
        }
        return null;
    }


    @Override
    public List<Doctor> findAll() {
        return doctors;
    }

    @Override
    public void save(Doctor doctor) {
        doctors.add(doctor);
        doctorMap.put(doctor.getId(), doctor);
    }

    @Override
    public void update(Doctor doctor) {
        String filePath = "src/listOfDoctors.txt";
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                if (id == doctor.getId()) {
                    lines.add(doctor.getId() + ", " + doctor.getName() + ", " + doctor.getSpecialization() + ", " +
                            doctor.getVisitsCount());
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при обновлении данных о враче в файле.");
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи обновленных данных о враче в файл.");
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Doctor doctor) {
        doctors.remove(doctor);
        doctorMap.remove(doctor.getId());
    }

}
