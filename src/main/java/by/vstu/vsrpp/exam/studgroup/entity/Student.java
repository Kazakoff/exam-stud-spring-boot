package by.vstu.vsrpp.exam.studgroup.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "studentyi")
public class Student {

	@Id
	@Column(name = "NomerZachetki")
	private Long nomerZachetki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonManagedReference
	@JoinColumn(name = "ShifrGruppyi", referencedColumnName = "Shifr", nullable = false)
	private Group group;

	@Column(name = "Familiya", length = 30, nullable = false)
	private String familiya;

	@Column(name = "Imya", length = 30, nullable = false)
	private String imya;

	@Column(name = "Otchestvo", length = 30, nullable = false)
	private String otchestvo;

	@Column(name = "Gorod", length = 30, nullable = false)
	private String gorod;

	@Column(name = "Adres", length = 80, nullable = false)
	private String adres;

	@Column(name = "Tel", length = 30, nullable = false)
	private String tel;

	@Column(name = "Status", length = 50)
	private String status;

	@Column(name = "StatusDate")
	private LocalDate statusDate;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(familiya);
		builder.append("]");
		return builder.toString();
	}

}
