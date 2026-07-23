package by.vstu.vsrpp.exam.studgroup.dto;

import java.time.LocalDate;
import java.util.List;

public class GroupResponse {
    private int shifr;
    private String nazvanie;
    private LocalDate dataFormir;
    private int kodPlana;
    private String status;
    private LocalDate statusDate;
    private List<StudentResponse> students;

    public int getShifr() {
        return shifr;
    }

    public void setShifr(int shifr) {
        this.shifr = shifr;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public LocalDate getDataFormir() {
        return dataFormir;
    }

    public void setDataFormir(LocalDate dataFormir) {
        this.dataFormir = dataFormir;
    }

    public int getKodPlana() {
        return kodPlana;
    }

    public void setKodPlana(int kodPlana) {
        this.kodPlana = kodPlana;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDate statusDate) {
        this.statusDate = statusDate;
    }

    public List<StudentResponse> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResponse> students) {
        this.students = students;
    }
}