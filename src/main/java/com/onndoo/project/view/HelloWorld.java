package com.onndoo.project.view;

import java.util.List;

import com.onndoo.project.model.Message;
import com.onndoo.project.service.MessageService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class HelloWorld {

	private Message message;
	private List<Message> messages;
	
	@Inject
	private MessageService messageService;
	
	@PostConstruct
	public void init() {
		message = new Message();
		messages = messageService.list();
	}
	
	public void submit() {
		messageService.create(message);
		messages.add(message);		
	}
}
