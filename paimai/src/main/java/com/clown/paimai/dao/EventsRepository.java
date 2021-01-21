package com.clown.paimai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class EventsRepository {
	
	@PersistenceContext
	private EntityManager emg; 

	public Events findById(Integer eventId) {
		return emg.find(Events.class, eventId); 
	}

	public List<Events> findAll() {
		Query query = emg.createQuery("from Events"); 
		return query.getResultList(); 
	}

	@Transactional
	public Events save(Events events) {
		emg.persist(events); 
		return events;
	}

	@Transactional
	public void delete(Events events) {
		emg.remove(events);
	}
}
