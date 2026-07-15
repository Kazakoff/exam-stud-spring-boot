package by.vstu.vsrpp.exam.studgroup.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddStudentsRequest {

	@NotNull
	@Min(1)
	private Integer count;

	@NotEmpty
	@Valid
	private List<StudentRequest> students = new ArrayList<>();

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<StudentRequest> getStudents() {
		return students;
	}

	public void setStudents(List<StudentRequest> students) {
		this.students = students;
	}
}
