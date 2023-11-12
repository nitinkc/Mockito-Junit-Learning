package com.learn.messenger.repository;

import com.learn.messenger.model.Message;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query("SELECT m FROM messages m WHERE LOWER(m.author) = LOWER(:author)")
    public Optional<List<Message>> retrieveMessagesByAuthor(@PathVariable("author") @NotBlank String author);
}
