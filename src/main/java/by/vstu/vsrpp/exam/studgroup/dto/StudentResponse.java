package by.vstu.vsrpp.exam.studgroup.dto;

import java.time.LocalDate;

public class StudentResponse {
    private Long nomerZachetki;
    private String familiya;
    private String imya;
    private String otchestvo;
    private String gorod;
    private String adres;
    private String tel;
    private String status;
    private LocalDate statusDate;

    public Long getNomerZachetki() {
        return nomerZachetki;
    }

    public void setNomerZachetki(Long nomerZachetki) {
        this.nomerZachetki = nomerZachetki;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getGorod() {
        return gorod;
    }

    public void setGorod(String gorod) {
        this.gorod = gorod;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
}