package by.vstu.vsrpp.exam.studgroup.service;

import java.util.List;
import by.vstu.vsrpp.exam.studgroup.dto.StudentRequest;
import by.vstu.vsrpp.exam.studgroup.dto.StudentResponse;

public interface StudentService {
    StudentResponse create(StudentRequest request);
    List<StudentResponse> findAll();
    StudentResponse findById(Long id);
    StudentResponse update(Long id, StudentRequest request);
    void delete(Long id);
}