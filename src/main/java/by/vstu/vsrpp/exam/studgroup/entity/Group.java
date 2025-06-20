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

@Entity
@Table(name = "groups", schema = "gr")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Shifr;

	@Column(unique = true)
	public String Nazvanie;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getShifr() {
		return Shifr;
	}

	public void setShifr(int shifr) {
		Shifr = shifr;
	}

	public String getNazvanie() {
		return Nazvanie;
	}

	public void setNazvanie(String nazvanie) {
		Nazvanie = nazvanie;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Group [name=");
		builder.append(Nazvanie);
		builder.append(", students=");
		builder.append(students);
		builder.append("]");
		return builder.toString();
	}

}
