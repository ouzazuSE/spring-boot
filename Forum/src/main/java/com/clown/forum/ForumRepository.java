package com.clown.forum;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ForumRepository {
	@PersistenceContext
	private EntityManager entityManager; 

	public Forum findById(Integer id) {
		return entityManager.find(Forum.class, id); 
	}

	public List<Forum> findAll() {
		Query query = entityManager.createQuery("from Forum"); 
		return query.getResultList();
	}

	@Transactional
	public Forum save(Forum forum) {
		entityManager.persist(forum); 
		return forum;
	}

	@Transactional
	public void delete(Forum forum) {
		entityManager.remove(forum);
	}
}
