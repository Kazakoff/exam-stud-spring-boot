package by.vstu.vsrpp.exam.studgroup.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class GroupRequest {

    @NotNull(message = "Шифр группы обязателен")
    private Integer shifr;

    @NotBlank(message = "Название группы обязательно")
    private String nazvanie;

    @NotNull(message = "Дата формирования обязательна")
    private LocalDate dataFormir;

    @NotNull(message = "Код плана обязателен")
    private Integer kodPlana;

    // Getters and Setters
    public Integer getShifr() { return shifr; }
    public void setShifr(Integer shifr) { this.shifr = shifr; }
    
    public String getNazvanie() { return nazvanie; }
    public void setNazvanie(String nazvanie) { this.nazvanie = nazvanie; }
    
    public LocalDate getDataFormir() { return dataFormir; }
    public void setDataFormir(LocalDate dataFormir) { this.dataFormir = dataFormir; }
    
    public Integer getKodPlana() { return kodPlana; }
    public void setKodPlana(Integer kodPlana) { this.kodPlana = kodPlana; }
}