package by.vstu.vsrpp.exam.studgroup.service;

import java.util.List;

import by.vstu.vsrpp.exam.studgroup.dto.AddStudentsRequest;
import by.vstu.vsrpp.exam.studgroup.entity.Group;

public interface GroupService {

	List<Group> findAll();

	Group addStudents(int groupId, AddStudentsRequest request);
}
