package by.vstu.vsrpp.exam.studgroup.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class AddStudentsRequest {


	@NotEmpty
	@Valid
	private List<StudentRequest> students = new ArrayList<>();

	public List<StudentRequest> getStudents() {
		return students;
	}

	public void setStudents(List<StudentRequest> students) {
		this.students = students;
	}
}
