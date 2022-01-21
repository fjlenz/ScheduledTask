package com.fj.ScheduledTask.repository;

import org.springframework.data.repository.CrudRepository;
import com.fj.ScheduledTask.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
    //Message findByName(String name);
}