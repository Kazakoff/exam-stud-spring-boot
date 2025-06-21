package by.vstu.vsrpp.exam.studgroup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int nomerZachetki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonManagedReference
	@JoinColumn(name = "ShifrGruppyi", referencedColumnName = "Shifr")
	public Group group;

	public Group getShifrGruppyi() {
		return group;
	}

	public void setShifrGruppyi(Group group) {
		this.group = group;
	}

	@Column
	public String familiya;

	public int getNomerZachetki() {
		return nomerZachetki;
	}

	public void setNomerZachetki(int nomerZachetki) {
		this.nomerZachetki = nomerZachetki;
	}

	public String getFamiliya() {
		return familiya;
	}

	public void setFamiliya(String familiya) {
		this.familiya = familiya;
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
