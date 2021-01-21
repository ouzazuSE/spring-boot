package com.clown.paimai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
public class JoinRepository {
	@PersistenceContext
	private EntityManager em; 
	
	public Join_event findById(Integer joinId) {
		return em.find(Join_event.class, joinId); 
	}

	public List<Join_event> findAll() {
		Query query = em.createQuery("from Join_event"); 
		return query.getResultList(); 
	}

	@Transactional
	public Join_event save(Join_event join_event) {
		em.persist(join_event); 
		return join_event;
	}

	@Transactional
	public void delete(Join_event join_event) {
		em.remove(join_event);
	}
}
