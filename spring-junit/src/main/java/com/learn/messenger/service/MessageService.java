package com.learn.messenger.service;

import com.learn.messenger.exceptions.MessageNotFoundException;
import com.learn.messenger.model.Message;
import com.learn.messenger.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, October/27/2020 at 10:45 PM
 */

@Service
public class MessageService {
    private MessageRepository messageRepository;

    public List<Message> findAll() {
       return messageRepository.findAll();
    }

    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    public List<Message> retrieveMessagesByAuthor(String author) {
        return messageRepository.retrieveMessagesByAuthor(author)
                .orElseThrow(() -> new MessageNotFoundException(author));
    }

    public Message deleteById(Long id) {
        Optional<Message> optional = messageRepository.findById(id);

        if(optional.isPresent()){
            messageRepository.deleteById(id);
        }

        return optional.get();
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
