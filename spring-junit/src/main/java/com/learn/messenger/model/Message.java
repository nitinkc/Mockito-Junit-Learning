package com.learn.messenger.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Size(min=2,message = "message should be atleast 5 characters long")
	@Column(name = "message")
	private String message;
	@Past(message = "Message Cannot be in the Future/Past")
	@Column(name = "create_dt")
	private Date created;
	@Column(name = "author")
	private String author;
}
