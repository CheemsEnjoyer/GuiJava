package data;

import javax.swing.table.AbstractTableModel;

public class DoctorTableModel extends AbstractTableModel {
    private Repository repository;

    public DoctorTableModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public int getRowCount() {
        if (repository != null) {
            return repository.getCount();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor doctor = repository.getDoctor(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex;
            case 1:
                return doctor.getName();
            case 2:
                return doctor.getSpecialization();
            case 3:
                return doctor.getVisitsCount();
            default:
                return "default";
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            Doctor doctor = repository.getDoctor(rowIndex);
            doctor.setVisitsCount((int) value);

            repository.save(doctor);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Имя";
            case 2:
                return "Специализация";
            case 3:
                return "Количество посещений";
            default:
                return "default";
        }
    }
}
