package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
