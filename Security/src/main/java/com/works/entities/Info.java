package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String url;
    private String userName;
    private String roles;
    private String sessionID;
    private String ip;
    private String agent;
    private Long time;

    public Info() {
    }

    public Info( String url, String userName, String roles, String sessionID, String ip, String agent, Long time) {
        this.url = url;
        this.userName = userName;
        this.roles = roles;
        this.sessionID = sessionID;
        this.ip = ip;
        this.agent = agent;
        this.time = time;
    }
}
