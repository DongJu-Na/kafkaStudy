package com.kafkaStudy.ndj.repository;

import com.kafkaStudy.ndj.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

}
