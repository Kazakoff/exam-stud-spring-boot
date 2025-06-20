package by.vstu.vsrpp.exam.studgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.vstu.vsrpp.exam.studgroup.entity.Group;
import by.vstu.vsrpp.exam.studgroup.service.GroupService;

@RestController
@RequestMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

	@Autowired
	private GroupService service;

	@GetMapping
	public ResponseEntity<List<Group>> get() {
		List<Group> entities = service.findAll();
		if (entities.isEmpty()) {
			return new ResponseEntity<>(entities, HttpStatus.OK);
		}
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

}
