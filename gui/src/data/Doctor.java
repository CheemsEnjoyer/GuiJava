package data;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private int visitsCount;

    // Конструктор
    public Doctor(int id, String name, String specialization, int visitCount) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.visitsCount = visitCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(int visitsCount) {
        this.visitsCount = visitsCount;
    }

    public int incrementVisitsCount() {
        visitsCount++;
        return visitsCount;
    }
}
