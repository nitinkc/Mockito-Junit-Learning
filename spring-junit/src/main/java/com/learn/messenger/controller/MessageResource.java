package com.learn.messenger.controller;

import com.learn.messenger.exceptions.MessageNotFoundException;
import com.learn.messenger.model.Message;
import com.learn.messenger.service.MessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messenger")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class MessageResource {

	//Constructor Injection, NO NEED of @AUTOWIRED Annotation
	private MessageService messageService;

	public MessageResource(MessageService messageService){
		this.messageService = messageService;
	}

	// Retrieve all users
	@GetMapping(path = "/all")
	public List<Message> retrieveAllUsers() {
		System.err.println("###################################### Retrieving All messages ######################################");
		return messageService.findAll();
	}

	// Retrieve all messages for a specific user
	@GetMapping(path = "/{id}/messages")
	public Message retrieveUserById(@PathVariable("id") @NotBlank Long id) {
		return messageService
				.findById(id)
				.orElseThrow(() -> new MessageNotFoundException("id:" + id));
	}

	//Retrieve all messages for a specific user
	@GetMapping(path = "/{author}/messages")
	public List<Message> findAuthorMessages(@PathVariable("author") @NotBlank String author){
		System.err.println("###################################### Retrieving All messages of a user ######################################");
		return messageService.retrieveMessagesByAuthor(author);
	}


	@DeleteMapping("/message/{id}")
	public Message deleteStudent(@PathVariable Long id) {
		return messageService.deleteById(id);
	}

	@PostMapping("/message")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Message message){
		System.err.println("###################################### POST Begins ######################################");
		Message savedStud = messageService.save(message);
		System.err.println("###################################### POST Ends ######################################");
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStud.getId())
				.toUri();

		return (ResponseEntity<Object>) ResponseEntity.created(location).build();
	}

	@PutMapping("/message/{id}")
	public Message modifyValue(@RequestBody Message newMessage, @PathVariable Long id){
		return messageService.findById(id)
				.map(message -> {
					message.setAuthor(newMessage.getAuthor());
					message.setCreated(newMessage.getCreated());
					message.setMessage(newMessage.getMessage());
					return messageService.save(message);
				})
				.orElseGet(() -> {
					newMessage.setId(id);
					return messageService.save(newMessage);
				});
	}
}
