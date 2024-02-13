package com.kafkaStudy.ndj.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int msId;
    @Column(name="MESSAGE", nullable = true)
    private String message;

    @CreationTimestamp
    @Column(name="REG_DTTM", updatable =false)
    private LocalDateTime regDttm;

    @Column(name="REG_USER_ID", nullable = false, length = 20)
    private String regUserId;

    @UpdateTimestamp
    @Column(name="ALT_DTTM")
    private LocalDateTime altDttm;

    @Column(name="ALT_USER_ID", length = 20)
    private String altUserId;


}
