package by.vstu.vsrpp.exam.studgroup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import by.vstu.vsrpp.exam.studgroup.dto.StudentRequest;
import by.vstu.vsrpp.exam.studgroup.dto.StudentResponse;
import by.vstu.vsrpp.exam.studgroup.service.StudentService;

@RestController
@RequestMapping(value = "/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id, @Valid @RequestBody StudentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}