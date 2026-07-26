package by.vstu.vsrpp.exam.studgroup.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.vstu.vsrpp.exam.studgroup.dto.AddStudentsRequest;
import by.vstu.vsrpp.exam.studgroup.dto.GroupRequest;
import by.vstu.vsrpp.exam.studgroup.dto.GroupResponse;
import by.vstu.vsrpp.exam.studgroup.entity.Group;
import by.vstu.vsrpp.exam.studgroup.entity.Student;
import by.vstu.vsrpp.exam.studgroup.exception.GroupValidationException;
import by.vstu.vsrpp.exam.studgroup.mappers.GroupMapper;
import by.vstu.vsrpp.exam.studgroup.repository.GroupRepository;
import by.vstu.vsrpp.exam.studgroup.repository.StudentRepository;
import by.vstu.vsrpp.exam.studgroup.service.GroupService;

@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    @Transactional
    public GroupResponse create(GroupRequest request) {
        Group group = groupMapper.toEntity(request);
        
        // Ручная валидация бизнес-правил через ValidStudentCountValidator
        Set<ConstraintViolation<Group>> violations = validator.validate(group);
        if (!violations.isEmpty()) {
            throw new GroupValidationException(
                violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
            );
        }

        Group saved = repository.save(group);
        return groupMapper.toResponse(saved);
    }

    @Override
    public List<GroupResponse> findAll() {
        return groupMapper.toResponseList(repository.findAll());
    }

    @Override
    public GroupResponse findById(int id) {
        Group group = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Группа с id " + id + " не найдена"));
        return groupMapper.toResponse(group);
    }

    @Override
    @Transactional
    public GroupResponse update(int id, GroupRequest request) {
        Group group = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Группа с id " + id + " не найдена"));

        // Обновляем поля существующей сущности
        groupMapper.updateEntityFromDto(request, group);

        // Валидация после обновления
        Set<ConstraintViolation<Group>> violations = validator.validate(group);
        if (!violations.isEmpty()) {
            throw new GroupValidationException(
                violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
            );
        }

        Group updated = repository.save(group);
        return groupMapper.toResponse(updated);
    }

    @Override
    @Transactional
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Группа с id " + id + " не найдена");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public GroupResponse addStudents(int groupId, AddStudentsRequest request) {
        Group group = repository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Группа с id " + groupId + " не найдена"));

    List<Student> newStudents = groupMapper.toEntityList(request.getStudents());


        // Временное добавление для валидации
        List<Student> tempStudents = new ArrayList<>(group.getStudents() != null ? group.getStudents() : List.of());
        tempStudents.addAll(newStudents);
        group.setStudents(tempStudents);

        Set<ConstraintViolation<Group>> violations = validator.validate(group);
        if (!violations.isEmpty()) {
            throw new GroupValidationException(
                violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
            );
        }
        newStudents.forEach(student -> student.setGroup(group));
        studentRepository.saveAll(newStudents);
        Group saved = repository.save(group);
        return groupMapper.toResponse(saved);
    }
}