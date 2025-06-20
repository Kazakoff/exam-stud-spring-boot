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

/*
  `Imya` char(30) NOT NULL,
  `Otchestvo` char(30) NOT NULL,
  `Gorod` char(30) NOT NULL,
  `Adres` char(80) NOT NULL,
  `Tel` char(30) NOT NULL,
`Status` varchar(50), */

@Entity
@Table(name = "students", schema = "gr")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int NomerZachetki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShifrGruppyi", referencedColumnName = "Shifr")
	public Group group;

	public Group getShifrGruppyi() {
		return group;
	}

	public void setShifrGruppyi(Group group) {
		this.group = group;
	}

	@Column
	public String Familiya;

	public int getNomerZachetki() {
		return NomerZachetki;
	}

	public void setNomerZachetki(int nomerZachetki) {
		NomerZachetki = nomerZachetki;
	}

	public String getFamiliya() {
		return Familiya;
	}

	public void setFamiliya(String familiya) {
		Familiya = familiya;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(Familiya);
		builder.append("]");
		return builder.toString();
	}

}
