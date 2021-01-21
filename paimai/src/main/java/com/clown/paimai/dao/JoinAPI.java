package com.clown.paimai.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class JoinAPI {

	@Autowired
	JoinRepository join;

	@GetMapping("/Join")
	public List<Join_event> getJoin_events() {
		return join.findAll();
	}

	@GetMapping("/Join/{id}")
	public Join_event getJoin_event(@PathVariable("id") Integer id) {
		return join.findById(id);
	}
	
	@PostMapping("/Join")
	public Join_event saveJoin_event(@RequestBody Join_event join_event) {
		return join.save(join_event);
	}

	@PutMapping("/Join")
	public Join_event editJoin_event(@RequestBody Join_event Join_event) {
		Join_event editJoin_event = join.findById(Join_event.getJoinId());
		editJoin_event.setEvents(Join_event.getEvents());
		editJoin_event.setUser(Join_event.getUser());
		return join.save(editJoin_event);
	}
	
	@DeleteMapping("/Join/{id}")
	public void deleteJoin_event(@PathVariable("id") Integer id) {
		Join_event Join_event = join.findById(id);
		join.delete(Join_event);
	}
}
