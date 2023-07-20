package com.works.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String sessionId;
    private String email;
    private String url;
    private String agent;
    private Date date;

    public Info() {
    }

    public Info(String sessionId, String email, String url, String agent, Date date) {
        this.sessionId = sessionId;
        this.email = email;
        this.url = url;
        this.agent = agent;
        this.date = date;
    }
}
