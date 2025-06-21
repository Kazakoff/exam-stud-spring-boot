package by.vstu.vsrpp.exam.studgroup.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int shifr;

	@Column(unique = true)
	public String nazvanie;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
	@JsonBackReference
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Group [name=");
		builder.append(nazvanie);
		builder.append(", students=");
		builder.append(students);
		builder.append("]");
		return builder.toString();
	}

}
