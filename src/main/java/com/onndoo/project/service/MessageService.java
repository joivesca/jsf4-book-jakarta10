package com.onndoo.project.service;

import java.util.List;

import com.onndoo.project.model.Message;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class MessageService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Message message) {
		entityManager.persist(message);
	}
	
	public List<Message> list() {
		return entityManager.createQuery("SELECT m FROM Message m", Message.class)
				.getResultList();
	}
	
}
