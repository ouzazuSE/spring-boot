package com.clown.forum;

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
public class ForumAPI {
	@Autowired
	ForumRepository repo;

	@GetMapping("/forum")
	public List<Forum> getCustomer() {
		return repo.findAll();
	}

	@GetMapping("/forum/{id}")
	public Forum getForum(@PathVariable("id") Integer id) {
		return repo.findById(id);
	}
	
	@PostMapping("/forum")
	public Forum saveForum(@RequestBody Forum forum) {
		return repo.save(forum);
	}

	@PutMapping("/forum")
	public Forum editForum(@RequestBody Forum forum) {
		Forum editForum = repo.findById(forum.getId());
		editForum.setDetail(forum.getDetail());
		editForum.setAuthor(forum.getAuthor());
		editForum.setLove(forum.getLove());
		editForum.setPost_date(forum.getPost_date());
		return repo.save(editForum);
	}
	
	@DeleteMapping("/forum/{id}")
	public void deleteForum(@PathVariable("id") Integer id) {
		Forum forum = repo.findById(id);
		repo.delete(forum);
	}
}
