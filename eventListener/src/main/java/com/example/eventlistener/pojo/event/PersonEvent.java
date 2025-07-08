package com.example.eventlistener.pojo.event;

import com.example.eventlistener.pojo.Person;
import lombok.Data;

@Data
public class PersonEvent {
    private Person person;

    private String addOrUpdate;

    public PersonEvent(Person person, String addOrUpdate) {
        this.person = person;
        this.addOrUpdate = addOrUpdate;
    }
}
