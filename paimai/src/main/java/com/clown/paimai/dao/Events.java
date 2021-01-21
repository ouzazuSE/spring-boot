package com.clown.paimai.dao;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Events{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;
	private String img;
	private String categories;
	private String eventName;
	private String discription;
	private String date;
	private String time;
	private String location;
	private Integer joinNum ;
	
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private User user;
	
	@JsonBackReference(value = "events-reference")
	public User getUser() {
		return user;
		}
	
	public void setUser(User user) {
		this.user = user;
		}

	@OneToMany(fetch = FetchType.EAGER, mappedBy="events")
	private List<Join_event> join;
	
	@JsonManagedReference(value = "join_event-reference")
	public List<Join_event> getJoin_event(){
		return join;
	}
	
	public void setJoin_event(List<Join_event> join) {
		this.join = join;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getJoinNum() {
		return joinNum;
	}

	public void setJoinNum(Integer joinNum) {
		this.joinNum = joinNum;
	}

	public List<Join_event> getJoin() {
		return join;
	}

	public void setJoin(List<Join_event> join) {
		this.join = join;
	}
	

	
	
	
}
